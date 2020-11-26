package com.woniuxy.service.impl;

import com.woniuxy.doman.LimoManage;
import com.woniuxy.doman.LimoMenu;
import com.woniuxy.mapper.LimoManageMapper;
import com.woniuxy.service.LimoManageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@Service
public class LimoManageServiceImpl extends ServiceImpl<LimoManageMapper, LimoManage> implements LimoManageService {
    @Autowired
    public LimoManageMapper manageMapper;
    @Override
    public List<LimoMenu> selectManagePermissions(LimoManage manage) throws Exception {
        return  manageMapper.selectManagePermissions(manage);
    }

    @Override
    public LimoManage manageLogin(String phone) throws Exception {
        return manageMapper.manageLogin(phone);
    }
}
