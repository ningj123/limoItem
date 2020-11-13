package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoCamp;
import com.woniuxy.dto.CampDto;
import com.woniuxy.mapper.LimoCampMapper;
import com.woniuxy.param.CampParam;
import com.woniuxy.service.LimoCampService;
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
 * @author wuyanzu
 * @since 2020-11-12
 */
@Service
public class LimoCampServiceImpl extends ServiceImpl<LimoCampMapper, LimoCamp> implements LimoCampService {
    @Resource
    private LimoCampMapper limoCampMapper;

    /**
     * 分页条件查询营地
     * @param campParam
     * @return
     * @throws Exception
     */
    @Override
    public Page<CampDto> selectCamp(CampParam campParam) throws Exception {
        Page<LimoCamp> page = new Page<>(campParam.getPageNum(), campParam.getPageSize());
        QueryWrapper<LimoCamp> queryWrapper = new QueryWrapper<>();
        if (campParam.getcStatus()!=null){
            queryWrapper.eq("c_status",campParam.getcStatus());
        }
        if (!StringUtils.isEmpty(campParam.getcName())){
            queryWrapper.eq("c_name",campParam.getcName());
        }
        limoCampMapper.selectPage(page,queryWrapper);
        Page<CampDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(page,dtoPage);
        return dtoPage;
    }

    /**
     * 下架营地
     * @param cId
     * @param cStatus
     * @throws Exception
     */
    @Override
    public void stopCamp(Integer cId, Integer cStatus) throws Exception {
        LimoCamp limoCamp = new LimoCamp();
        limoCamp.setcId(cId);
        limoCamp.setcStatus(cStatus);
        limoCampMapper.updateById(limoCamp);
    }

    /**
     * 新增营地信息
     * @param campParam
     * @throws Exception
     */
    @Override
    public void insertCamp(CampParam campParam) throws Exception {
        LimoCamp limoCamp = new LimoCamp();
        BeanUtils.copyProperties(campParam,limoCamp);
        limoCampMapper.insert(limoCamp);
    }

}
