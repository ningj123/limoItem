package com.woniuxy.service.impl;

import com.woniuxy.doman.LimoActivity;
import com.woniuxy.dao.LimoActivityMapper;
import com.woniuxy.dto.LimoActivityDto;
import com.woniuxy.dto.LimoCampDto;
import com.woniuxy.dto.LimoCollectDto;
import com.woniuxy.param.LimoActivityParam;
import com.woniuxy.service.LimoActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cgx
 * @since 2020-11-07
 */
@Service
public class LimoActivityServiceImpl extends ServiceImpl<LimoActivityMapper, LimoActivity> implements LimoActivityService {
    @Autowired
    public LimoActivityMapper activityMapper;

    //从首页传入当前的城市。显示当前城市的营地
    @Override
    public List<LimoCampDto> selectCamp(String city) throws Exception {
        List<LimoCampDto> limoCampDto= activityMapper.selectCamp(city);
        return limoCampDto;
    }
    //进入活动首页,根据传过来的当前城市，分页展示当前城市营地活动
    @Override
    public List<LimoActivity> selectCampActivitiesLimt(String city,Integer pageIndex) throws Exception {
        return activityMapper.selectCampActivitiesLimt(city,pageIndex);
    }
    //点击某个营地展示当前营地下的营地活动
    @Override
    public List<LimoActivity> selectCampActive(String name) throws Exception {
        return activityMapper.selectCampActive(name);
    }
    //查询某营地活动属于哪个营地    属于   收藏营地活动到个人中心
    @Override
    public LimoCollectDto selectActivesBelongToCamp(Integer aid) throws Exception {
        return activityMapper.selectActivesBelongToCamp(aid);
    }
    //判断当前营地是否为正常状态
    @Override
    public List<LimoCampDto> selectCampStatus(String city) throws Exception {
        return  activityMapper.selectCampStatus(city);
    }


}
