package com.woniuxy.service;

import com.woniuxy.doman.LimoActivity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.LimoActivityDto;
import com.woniuxy.dto.LimoCampDto;
import com.woniuxy.dto.LimoCollectDto;
import com.woniuxy.param.LimoActivityParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cgx
 * @since 2020-11-07
 */
public interface LimoActivityService extends IService<LimoActivity> {

    //从首页传入当前的城市。显示当前城市的营地
    public List<LimoCampDto> selectCamp(String city)throws Exception;
    //进入活动首页,根据传过来的当前城市，分页展示当前城市营地活动
    public List<LimoActivity> selectCampActivitiesLimt(String city,Integer pageIndex)throws Exception;
    //点击某个营地展示当前营地下的营地活动
    public List<LimoActivity> selectCampActive(String name)throws Exception;
    //查询某营地活动属于哪个营地    属于   收藏营地活动到个人中心
    public LimoCollectDto selectActivesBelongToCamp(Integer aid)throws Exception;
    //判断当前营地是否为正常状态
    public List<LimoCampDto>  selectCampStatus(String city)throws Exception;
}
