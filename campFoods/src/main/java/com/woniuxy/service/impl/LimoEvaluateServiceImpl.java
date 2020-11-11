package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoEvaluate;
import com.woniuxy.dto.EvaluateDto;
import com.woniuxy.mapper.LimoEvaluateMapper;
import com.woniuxy.param.EvaluateParam;
import com.woniuxy.service.LimoEvaluateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@Service
public class LimoEvaluateServiceImpl extends ServiceImpl<LimoEvaluateMapper, LimoEvaluate> implements LimoEvaluateService {
    @Autowired
    private LimoEvaluateMapper limoEvaluateMapper;
    @Override
    public Page<LimoEvaluate> selectEvaluate(EvaluateParam evaluateParam) throws Exception {
        Page<LimoEvaluate> page = new Page<>(evaluateParam.getPageNum(), evaluateParam.getPageSize());
        QueryWrapper<LimoEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id",evaluateParam.getPId()).eq("ev_type",evaluateParam.getEvType());
        if(evaluateParam.getUId()!=null){
            queryWrapper.eq("u_id",evaluateParam.getUId());
        }
        limoEvaluateMapper.selectPage(page,queryWrapper);
        return page;
    }
}
