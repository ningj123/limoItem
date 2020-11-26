package com.woniuxy.mapper;

import com.woniuxy.doman.LimoManage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.woniuxy.doman.LimoMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
public interface LimoManageMapper extends BaseMapper<LimoManage> {
    //查询当前管理员有哪些权限
    @Select("SELECT m.* FROM limo_permission lp JOIN limo_menu m on lp.m_id=m.m_id WHERE lp.r_id=#{rId}")
    public List<LimoMenu> selectManagePermissions(LimoManage Manage)throws Exception;
    //管理员登录
    @Select("SELECT m_id,m_name,m_phone,m_password,m_email,r_id FROM limo_manage WHERE m_phone=#{phone}")
    public LimoManage manageLogin(String phone) throws Exception;
}
