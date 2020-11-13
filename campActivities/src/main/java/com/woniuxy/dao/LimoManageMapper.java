package com.woniuxy.dao;

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
 * @author cgx
 * @since 2020-11-12
 */
public interface LimoManageMapper extends BaseMapper<LimoManage> {
    //查询当前管理员有哪些权限
    @Select("SELECT m.* FROM limo_permission lp JOIN limo_menu m on lp.m_id=m.m_id WHERE lp.r_id=#{rId}")
    public List<LimoMenu> selectManagePermissions(LimoManage Manage)throws Exception;
    //管理员登录
    @Select("SELECT m_password,m_phone FROM limo_manage WHERE m_phone=#{phone}")
    public LimoManage manageLogin(String phone) throws Exception;
}
