package com.woniuxy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.doman.LimoSecSpot;
import com.woniuxy.dto.LimoSecSpotDto;
import com.woniuxy.exception.TravelExecption;
import com.woniuxy.mapper.LimoSecSpotMapper;
import com.woniuxy.param.PointParam;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-10
 */
@Service
public class LimoSecSpotServiceImpl extends ServiceImpl<LimoSecSpotMapper, LimoSecSpot> implements LimoSecSpotService {

    @Resource
    private LimoSecSpotMapper limoSecSpotMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplates;
    /**
     * @Author zhuyuli
     * @Description 条件查询周边景点
     * @Date 2020/11/11 10:53
     * @Param [param]
     * @return java.lang.Object
     **/
    @Override
    public Object queryByParam(SortTypeParam param) throws  Exception{
        Page<LimoSecSpot> page = new Page<LimoSecSpot>(param.getPageNum(), param.getPageSize());
        QueryWrapper<LimoSecSpot> queryWrapper = new QueryWrapper<>();
        //判断城市不为空
        if(StringUtils.isNotBlank(param.getCity())){
            queryWrapper.eq("sec_sport_city",param.getCity());
        }
        //判断营地ID不为空
        if(param.getCId()!=-1 && param.getCId()!=null){
            queryWrapper.eq("c_id",param.getCId());
        }
        //条件查询景点名字和营地名字
        if(StringUtils.isNotBlank(param.getSecname())){
            queryWrapper.and(Wrapper->Wrapper.like("c_name",param.getSecname()).or().like("sec_sport_name",param.getSecname()));
        }

        limoSecSpotMapper.selectPage(page,queryWrapper);
        //封装dto
        Page<LimoSecSpotDto> page2 = new Page<LimoSecSpotDto>();
        BeanUtils.copyProperties(page,page2);
        page=null;
        return page2;
    }
    /**
     * @Author zhuyuli
     * @Description 新增周边景点
     * @Date 2020/11/12 10:52
     * @Param [param]
     * @return void
     **/
    @Override
    public void insertSport(SortParam param) throws  Exception{
        LimoSecSpot sort = new LimoSecSpot();
        BeanUtils.copyProperties(param,sort);
        limoSecSpotMapper.insert(sort);
        //Long addedNum = redisTemplate.opsForGeo().add("city", new Point(113.27, 23.13), "广州");
        redisTemplates.opsForGeo().add("sec", new Point(param.getPrecision(), param.getDimension()), param.getSecSportName());

    }
    /***
     * 以给定的城市为中心， 返回键包含的位置元素当中， 与中心的距离不超过给定最大距离的所有位置元素，并给出所有位置元素与中心的平均距离。
     * @param //precision 经度 必须是存在redis中的名字
     * @param //dimension 纬度 必须是存在redis中的名字
     * @param //ditance 距离 必须是存在redis中的名字
     * @return
     */
    @Override
    public List<LimoSecSpotDto> geoNearByPlace(PointParam param) {

        Distance distances = new Distance(param.getDistance(), Metrics.KILOMETERS);//params: 距离量, 距离单位

        Circle circle = new Circle(new Point(param.getPrecision(), param.getDimension()), distances);
        GeoResults<RedisGeoCommands.GeoLocation<Object>> sec = redisTemplates.opsForGeo().radius("sec", circle);
        //RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending();
        //GeoResults<RedisGeoCommands.GeoLocation<Object>> sec = redisTemplates.opsForGeo().radius("sec", name, distances, args);
        //取出redis里面符合位置的景区
        List<GeoResult<RedisGeoCommands.GeoLocation<Object>>> content = sec.getContent();
        //new 集合封装数据返回前段
        ArrayList<LimoSecSpotDto> secSpots = new ArrayList<>();
        //循环得到数据库的值
        for(int i=0;i<content.size();i++){
            QueryWrapper<LimoSecSpot> wrapper = new QueryWrapper<>();
            wrapper.eq("sec_sport_name",content.get(i).getContent().getName());
            //得到景区的对象
            LimoSecSpot spot = limoSecSpotMapper.selectOne(wrapper);
            LimoSecSpotDto spotDto = new LimoSecSpotDto();
            //转换为Dto对象
            BeanUtils.copyProperties(spot,spotDto);
            List<Point> position = redisTemplates.opsForGeo().position("sec",spot.getSecSportName());
            //把经纬set进去
            spotDto.setPrecision((float) position.get(0).getX());
            spotDto.setDimension((float) position.get(0).getY());
            secSpots.add(spotDto);
        }

        System.out.println(sec.getContent().get(0).getContent().getName());
        return secSpots;
    }
    /**
     * @Author zhuyuli
     * @Description //根据ID查询周边景点
     * @Date 2020/11/12 15:51
     * @Param [id]
     * @return com.woniuxy.doman.LimoSecSpot
     **/
    @Override
    public LimoSecSpotDto queryById(Integer id) {
        //先去redis缓存中查询
        Object secNew = redisTemplates.opsForHash().get("secNew", "sec:" + id);


        String secNewjson = JSON.toJSONString(secNew);//将对象转json
        LimoSecSpot spot = JSON.parseObject(secNewjson, LimoSecSpot.class);

        //判断缓存中是否存在
        if(spot==null || spot.equals("")){
            //不存在，就去数据库中查询
            LimoSecSpot limoSecSpot = limoSecSpotMapper.selectById(id);
            //并把查询的数据存到redis中
            if(limoSecSpot==null||limoSecSpot.equals("")){
                 return null;
            }
            redisTemplates.opsForHash().put("secNew","sec:"+limoSecSpot.getSecId(),null);
            //并把值赋给之前转换的对象
            spot=limoSecSpot;
        }

        //通过key获取地方的point坐标
        List<Point> sec = redisTemplates.opsForGeo().position("sec", spot.getSecSportName());
        //转换对象
        LimoSecSpotDto spotDto = new LimoSecSpotDto();
        BeanUtils.copyProperties(spot,spotDto);
        //封装坐标
        spotDto.setPrecision((float) sec.get(0).getX());
        spotDto.setDimension((float) sec.get(0).getY());
        return spotDto;
    }

    /***
     * 将指定的地理空间位置（纬度、经度、名称）添加到指定的key中。
     * 把所有的景区存到redis中
     * 初始化数据
     */
    @Override
    public Long redisGeoAdd() {
        redisTemplates.opsForGeo().add("sec", new Point(107.738144, 29.487602), "重庆武隆仙女山国家森林公园");
        redisTemplates.opsForGeo().add("sec", new Point(104.23567, 33.26142), "九寨沟县");
        redisTemplates.opsForGeo().add("sec", new Point(106.516357, 29.667259), "重庆欢乐谷");
        redisTemplates.opsForGeo().add("sec", new Point(113.12931, 29.37197), "岳阳楼");
        redisTemplates.opsForGeo().add("sec", new Point(110.55042, 29.34589), "张家界");
        redisTemplates.opsForGeo().add("sec", new Point(100.066132, 29.309271), "稻城·亚丁");
        List<LimoSecSpot> secSpots = limoSecSpotMapper.selectList(null);
        for(LimoSecSpot i:secSpots){
            redisTemplates.opsForHash().put("secNew","sec:"+i.getSecId(),i);
        }

        return 200l;
    }
}
