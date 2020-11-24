package com.woniuxy.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.doman.LimoBanner;
import com.woniuxy.doman.LimoCity;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.dto.LimoSortDetailDto;
import com.woniuxy.mapper.LimoCityMapper;
import com.woniuxy.mapper.LimoSortDetailMapper;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.LSDParam1;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.util.IpAddress;
import org.apache.ibatis.jdbc.SQL;
import org.apache.velocity.runtime.directive.Foreach;
//import org.redisson.Redisson;
//import org.redisson.api.RLock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-07
 */
@Service
public class LimoSortDetailServiceImpl extends ServiceImpl<LimoSortDetailMapper, LimoSortDetail> implements LimoSortDetailService {
    @Resource
    private LimoSortDetailMapper  limoSortDetailMapper;
    @Resource
    private LimoCityMapper limoCityMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    //@Resource
    //private Redisson redisson;
    /**
     * @Author zhuyuli
     * @Description //查询旅游攻略（4个指南）
     * @Date 2020/11/9 17:32
     * @Param []
     * @return java.lang.Object
     **/
    @Override
    public Object selectAll()throws Exception {
        //根据循环查询4和类别的文章
        String[] src={"hort","camp","food","scenic"};
        HashMap<String,Object> map=new HashMap();
        for(int i=0;i<3;i++){
            QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
            Page<LimoSortDetail> Page = new Page<LimoSortDetail>(1,2);
            queryWrapper.eq("so_d_type",i);

            limoSortDetailMapper.selectPage(Page,queryWrapper);
            List<LimoSortDetail> records = Page.getRecords();
            ArrayList<LimoSortDetailDto> dtos = new ArrayList<>();
            for(int j=0;j<records.size();j++){
                LimoSortDetailDto detailDto = new LimoSortDetailDto();
                BeanUtils.copyProperties(records.get(j),detailDto);
                List list = JSON.parseObject(records.get(j).getSoDImages(), List.class);
                detailDto.setSoDImages(list);
                dtos.add(detailDto);
            }
            map.put(src[i],dtos);
        }
        //查询城市的类别
        Page<LimoCity> Page = new Page<LimoCity>(1,2);
        limoCityMapper.selectPage(Page,null);
        //根据城市查询有多少文章
        for(int i=0;i<Page.getRecords().size();i++){
            QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("so_d_city",Page.getRecords().get(i).getCity());
            Integer count = limoSortDetailMapper.selectCount(queryWrapper);
            Page.getRecords().get(i).setTatol(count);
        }
        map.put("city",Page.getRecords());
        return map;
    }
    /**
     * @Author zhuyuli
     * @Description 根据类型或关键字分页查询列表
     * @Date 2020/11/10 9:50
     * @Param [param]
     * @return java.lang.Object
     **/
    @Override
    public Object selectByType(TypeParam param) throws Exception{
        Page<LimoSortDetail> Page = new Page<LimoSortDetail>(param.getPageNum(),param.getPageSize());
        QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
        //如果type=-1,为空，参数为空
        if(param.getType()!=-1 && param.getType()!=null ){

            queryWrapper.eq("so_d_type",param.getType());
        }
        //判断关键字不为空
        if(param.getKeyWord()!=null && !param.getKeyWord().equals("")){

            queryWrapper.like("so_d_keyword",param.getKeyWord());
        }
        limoSortDetailMapper.selectPage(Page,queryWrapper);
        Page<LimoSortDetailDto> page2 = new Page<LimoSortDetailDto>();
        List<LimoSortDetail> records = Page.getRecords();
        ArrayList<LimoSortDetailDto> dtos = new ArrayList<>();
        for(int j=0;j<records.size();j++){
            LimoSortDetailDto detailDto = new LimoSortDetailDto();
            BeanUtils.copyProperties(records.get(j),detailDto);
            List list = JSON.parseObject(records.get(j).getSoDImages(), List.class);
            detailDto.setSoDImages(list);
            dtos.add(detailDto);
        }
        BeanUtils.copyProperties(Page,page2);
        Page=null;
        page2.setRecords(dtos);
        return page2;
    }

    @Override
    public List queryAll() {
        List<LimoSortDetail> limoSortDetails = limoSortDetailMapper.selectList(null);
        //封装dto
        List<LimoSortDetailDto> limoSortDetailDtos = new ArrayList<LimoSortDetailDto>();
        for(LimoSortDetail i:limoSortDetails){
            LimoSortDetailDto dto=new LimoSortDetailDto();
            BeanUtils.copyProperties(i,dto);
            limoSortDetailDtos.add(dto);
        }
        limoSortDetails=null;
        return limoSortDetailDtos;
    }

    @Override
    public Object selectById(Integer id, HttpServletRequest request) {

        LimoSortDetail detail = limoSortDetailMapper.selectById(id);
        String ipAddr = IpAddress.getIpAddr(request);
        String s1 = redisTemplate.opsForValue().get("ip:" + ipAddr+":"+detail.getSoDId());
        if(StringUtils.isBlank(s1)){
           // redisTemplate.expire("ip:"+ipAddr,60, TimeUnit.SECONDS);
            redisTemplate.opsForValue().set("ip:"+ipAddr+":"+detail.getSoDId(), "detail.getSoDId()", 60, TimeUnit.SECONDS);
            redisTemplate.opsForValue().increment("sort:"+detail.getSoDId(), 1);
        }

        String s = redisTemplate.opsForValue().get("sort:" + detail.getSoDId());
        Integer i=Integer.parseInt(s);
        detail.setSoDTwo(i);
        if(i%10==0){
            UpdateWrapper<LimoSortDetail> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("so_d_id",detail.getSoDId());
            updateWrapper.set("so_d_two",i);
            limoSortDetailMapper.update(null,updateWrapper);
        }
        List list = JSON.parseObject(detail.getSoDImages(), List.class);
        LimoSortDetailDto detailDto = new LimoSortDetailDto();
        BeanUtils.copyProperties(detail,detailDto);
        detailDto.setSoDImages(list);
        return detailDto;
    }

    /**
     * @Author zhuyuli
     * @Description 根据ID更新旅游文章
     * @Date 2020/11/13 15:03
     * @Param [param]
     * @return void
     **/
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateTravelSort(LSDParam param) throws Exception {
        LimoSortDetail limo = new LimoSortDetail();
        BeanUtils.copyProperties(param, limo);
        limoSortDetailMapper.updateById(limo);
    }

    @Override
    public void saveDetail(LSDParam1 param, Map<String, Object> map) {
        //RLock lock = redisson.getLock("mylock");
        //lock.lock();
        LimoSortDetail limo = new LimoSortDetail();
        BeanUtils.copyProperties(param, limo);
        limoSortDetailMapper.insert(limo);
        //lock.unlock();
    }
}
