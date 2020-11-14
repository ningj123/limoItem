package com.woniuxy.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoSecSpot;
import com.woniuxy.dto.LimoSecSpotDto;
import com.woniuxy.mapper.LimoSecSpotMapper;
import com.woniuxy.param.PointParam;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javafx.scene.shape.Circle;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
@Service
public class LimoSecSpotServiceImpl extends ServiceImpl<LimoSecSpotMapper, LimoSecSpot> implements LimoSecSpotService {
    @Resource
    private LimoSecSpotMapper limoSecSpotMapper;

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
     }
    /**
     * @Author zhuyuli
     * @Description //更新周边景点
     * @Date 2020/11/13 15:29
     * @Param [param]
     * @return void
     **/
    @Override
    public void updateSport(SortParam param) throws Exception {
        LimoSecSpot spot = new LimoSecSpot();
        BeanUtils.copyProperties(param,spot);
        limoSecSpotMapper.updateById(spot);
    }
}
