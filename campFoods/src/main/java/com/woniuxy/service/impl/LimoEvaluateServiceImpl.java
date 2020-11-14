package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoEvaluate;
import com.woniuxy.domain.LimoUser;
import com.woniuxy.dto.EvaluateDto;
import com.woniuxy.dto.UserDto;
import com.woniuxy.mapper.LimoEvaluateMapper;
import com.woniuxy.mapper.LimoUserMapper;
import com.woniuxy.param.EvaluateParam;
import com.woniuxy.service.LimoEvaluateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private LimoEvaluateMapper limoEvaluateMapper;
    @Resource
    private LimoUserMapper limoUserMapper;

    /**
     * 查询评价信息
     * @param evaluateParam
     * @return
     * @throws Exception
     */
    @Override
    public Page<EvaluateDto> selectEvaluate(EvaluateParam evaluateParam) throws Exception {
        Page<LimoEvaluate> page = new Page<>(evaluateParam.getPageNum(), evaluateParam.getPageSize());
        QueryWrapper<LimoEvaluate> queryWrapper = new QueryWrapper<>();
        if(evaluateParam.getAId()!=null && evaluateParam.getAId()>0){
            queryWrapper.eq("a_id",evaluateParam.getAId());
        }
        if (evaluateParam.getPId()!=null && evaluateParam.getPId()>0){
            queryWrapper.eq("p_id",evaluateParam.getPId());
        }
        if(evaluateParam.getUId()!=null && evaluateParam.getUId()>0){
            queryWrapper.eq("u_id",evaluateParam.getUId());
        }
        limoEvaluateMapper.selectPage(page,queryWrapper);
        //查询评价的用户信息
        List<LimoEvaluate> records = page.getRecords();
        ArrayList<EvaluateDto> list = new ArrayList<>();
        for (LimoEvaluate evaluate:records){
            LimoUser user = limoUserMapper.selectById(evaluate.getUId());
            EvaluateDto evaluateDto = new EvaluateDto();
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(evaluate,evaluateDto);
            BeanUtils.copyProperties(user,userDto);
            evaluateDto.setUserDto(userDto);
            list.add(evaluateDto);
        }
        Page<EvaluateDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(page,dtoPage);
        dtoPage.setRecords(list);
        return dtoPage;
    }

    /**
     * 新增评价
     * @param evaluateParam
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertEvaluate(EvaluateParam evaluateParam) throws Exception {
        LimoEvaluate evaluate = new LimoEvaluate();
        BeanUtils.copyProperties(evaluateParam,evaluate);
        limoEvaluateMapper.insert(evaluate);
    }
}
