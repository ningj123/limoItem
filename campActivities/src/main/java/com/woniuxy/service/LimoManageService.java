package com.woniuxy.service;

import com.woniuxy.doman.LimoManage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.doman.LimoMenu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cgx
 * @since 2020-11-12
 */
public interface LimoManageService extends IService<LimoManage> {

    //查询当前管理员有哪些权限
    public List<LimoMenu> selectManagePermissions(LimoManage Manage)throws Exception;
    //管理员登录
    public LimoManage manageLogin(String phone)throws Exception;

}
