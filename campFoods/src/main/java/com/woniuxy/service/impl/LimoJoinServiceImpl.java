package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoJoin;
import com.woniuxy.mapper.LimoJoinMapper;
import com.woniuxy.param.JoinParam;
import com.woniuxy.service.LimoJoinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@Service
public class LimoJoinServiceImpl extends ServiceImpl<LimoJoinMapper, LimoJoin> implements LimoJoinService {
    @Resource
    private LimoJoinMapper limoJoinMapper;
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
        if(joinParam.getJType()!=null){
            queryWrapper.eq("j_type",joinParam.getJType());
        }
        if(!StringUtils.isEmpty(joinParam.getJPhone())){
            queryWrapper.eq("j_phone",joinParam.getJPhone());
        }
        if(!StringUtils.isEmpty(joinParam.getJName())){
            queryWrapper.like("j_name",joinParam.getJName());
        }
        limoJoinMapper.selectPage(page,queryWrapper);
        return page;
    }

    /**
     * 根据加盟编号查询加盟详情
     * @param joinParam
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void updateStatus(JoinParam joinParam) throws Exception {
        LimoJoin limoJoin = new LimoJoin();
        BeanUtils.copyProperties(joinParam,limoJoin);
        limoJoinMapper.updateById(limoJoin);
    }
}
