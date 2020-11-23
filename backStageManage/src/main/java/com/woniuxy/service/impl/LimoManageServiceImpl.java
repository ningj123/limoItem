package com.woniuxy.service.impl;

import com.woniuxy.domain.LimoManage;
import com.woniuxy.domain.LimoMenu;
import com.woniuxy.mapper.LimoManageMapper;
import com.woniuxy.service.LimoManageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cgx
 * @since 2020-11-12
 */
@Service
public class LimoManageServiceImpl extends ServiceImpl<LimoManageMapper, com.woniuxy.domain.LimoManage> implements LimoManageService {

    @Resource
    public LimoManageMapper manageMapper;
    //查询当前管理员有哪些权限
    @Override
    public List<LimoMenu> selectManagePermissions(LimoManage manage) throws Exception {
        return  manageMapper.selectManagePermissions(manage);
    }
    //管理员登录
    @Override
    public LimoManage manageLogin(String phone) throws Exception {
        return manageMapper.manageLogin(phone);
    }
}
