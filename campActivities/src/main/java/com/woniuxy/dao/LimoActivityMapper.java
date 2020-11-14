package com.woniuxy.dao;

import com.woniuxy.doman.LimoActivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.dto.LimoActivityDto;
import com.woniuxy.dto.LimoCampDto;
import com.woniuxy.dto.LimoCollectDto;
import com.woniuxy.param.LimoActivityParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cgx
 * @since 2020-11-07
 */
public interface LimoActivityMapper extends BaseMapper<LimoActivity> {

    //从首页传入当前的城市。显示当前城市的营地
    @Select("SELECT c_name,c_status FROM limo_camp WHERE c_city=#{city} AND c_status=0")
    public List<LimoCampDto> selectCamp(String city) throws Exception;

    //进入活动首页,根据传过来的当前城市，分页展示当前城市营地活动   没用
    @Select("SELECT a_id,a_name,a_images,a_city,a_type,a_price FROM limo_activity WHERE a_city=#{city} LIMIT #{pageIndex},2")
    public List<LimoActivity> selectCampActivitiesLimt(String city,Integer pageIndex) throws Exception;

    //点击某个营地展示当前营地下的营地活动
    @Select("SELECT ac.a_id,ac.a_name,ac.a_price,ac.a_images,ac.a_type FROM limo_activity ac JOIN limo_camp ca " +
            "on ac.c_id=ca.c_id WHERE ca.c_name=#{name}")
    public List<LimoActivity> selectCampActive(String name)throws Exception;

    //查询某营地活动属于哪个营地    属于   收藏营地活动到个人中心
    @Select("SELECT camp.c_id,camp.c_name FROM limo_activity ac JOIN limo_camp camp on camp.c_id=ac.c_id WHERE ac.a_id=#{aid}")
    public LimoCollectDto selectActivesBelongToCamp(Integer aid)throws Exception;

    //判断当前营地是否为正常状态
    @Select("SELECT c_status FROM limo_camp WHERE c_city=#{city}")
    public List<LimoCampDto> selectCampStatus(String city)throws Exception;
}
