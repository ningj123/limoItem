package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoCamp;
import com.woniuxy.domain.LimoJoin;
import com.woniuxy.domain.LimoManage;
import com.woniuxy.domain.LimoRole;
import com.woniuxy.mapper.LimoCampMapper;
import com.woniuxy.mapper.LimoJoinMapper;
import com.woniuxy.mapper.LimoManageMapper;
import com.woniuxy.mapper.LimoRoleMapper;
import com.woniuxy.param.JoinParam;
import com.woniuxy.service.LimoJoinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
@Service
public class LimoJoinServiceImpl extends ServiceImpl<LimoJoinMapper, LimoJoin> implements LimoJoinService {
    @Resource
    private LimoJoinMapper limoJoinMapper;
    @Resource
    private LimoCampMapper limoCampMapper;
    @Resource
    private LimoManageMapper limoManageMapper;
    @Resource
    private LimoRoleMapper limoRoleMapper;
    /**
     * 查询加盟信息
     * @param joinParam
     * @return
     * @throws Exception
     */
    @Override
    public Page<LimoJoin> selectJion(JoinParam joinParam) throws Exception {
        Page<LimoJoin> page = new Page<>(joinParam.getPageNum(), joinParam.getPageSize());
        QueryWrapper<LimoJoin> queryWrapper = new QueryWrapper<>();
        if(joinParam.getjType()!=null){
            queryWrapper.eq("j_type",joinParam.getjType());
        }
        if(!StringUtils.isEmpty(joinParam.getjPhone())){
            queryWrapper.eq("j_phone",joinParam.getjPhone());
        }
        if(!StringUtils.isEmpty(joinParam.getjName())){
            queryWrapper.like("j_name",joinParam.getjName());
        }
        limoJoinMapper.selectPage(page,queryWrapper);
        return page;
    }

    /**
     * 根据加盟编号修改加盟状态
     * @param joinParam
     * @throws Exception
     */
    @Override
    public void updateStatus(JoinParam joinParam) throws Exception {
        LimoJoin limoJoin = new LimoJoin();
        BeanUtils.copyProperties(joinParam,limoJoin);
        int update = limoJoinMapper.updateById(limoJoin);
        if (joinParam.getjStatus()==1 && update>0){
            //将营地信息存入营地表
            LimoJoin join = limoJoinMapper.selectById(joinParam.getjId());
            LimoCamp limoCamp = new LimoCamp();
            limoCamp.setcAddress(join.getjLimoAddress());
            limoCamp.setcCity(join.getCity());
            limoCamp.setcImages(join.getjLimoImages());
            limoCamp.setcName(join.getjCampName());
            limoCamp.setcPhone(join.getjPhone());
            limoCampMapper.insert(limoCamp);
            //将营地加盟人信息存入营地管理人信息表
            LimoManage limoManage = new LimoManage();
            limoManage.setmName(join.getjName());
            limoManage.setmPhone(join.getjPhone());
            QueryWrapper<LimoRole> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("r_name","营地管理员");
            LimoRole limoRole = limoRoleMapper.selectOne(queryWrapper);
            limoManage.setrId(limoRole.getrId());
            limoManage.setmPassword("123456");
            limoManageMapper.insert(limoManage);
        }
    }

}
