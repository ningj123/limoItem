package com.woniuxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.domain.LimoCamp;
import com.woniuxy.domain.LimoCampExample;
import com.woniuxy.dto.CampDto;
import com.woniuxy.exception.ErrorException;
import com.woniuxy.mapper.LimoCampMapper;
import com.woniuxy.service.CampService;
import com.woniuxy.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CampServiceImpl
 * @Author shadow
 * @Date 2020/11/9 13:08
 * @Description TODO
 **/
@Service
public class CampServiceImpl implements CampService {
    @Resource
    private LimoCampMapper limoCampMapper;
    @Override
    public PageInfo<CampDto> selectCampsByCity(String city,String context, PageVO pageVO) throws Exception {
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        LimoCampExample example = new LimoCampExample();
        if(city!=null){
            example.createCriteria().andCCityLike(city);
        }
        if(context!=null){
            example.createCriteria().andCNameLike(context);
        }
        example.createCriteria().andCStatusEqualTo(0);
        List<LimoCamp> list = limoCampMapper.selectByExample(example);
        PageInfo<LimoCamp> pageInfo = new PageInfo<LimoCamp>(list);
        PageInfo<CampDto> pageInfo2 = new PageInfo<CampDto>();
        BeanUtils.copyProperties(pageInfo,pageInfo2);
        return pageInfo2;
    }

    @Override
    public CampDto selectCampById(Integer id) throws Exception {
        LimoCamp limoCamp = limoCampMapper.selectByPrimaryKey(id);
        CampDto campDto=null;
        if(limoCamp!=null){
            campDto=new CampDto();
            BeanUtils.copyProperties(limoCamp,campDto);
        }else{
            throw new ErrorException("没有该营地");
        }
        return campDto;
    }

    @Override
    public List<CampDto> selectCamps() throws Exception {
        List<LimoCamp> limoCamps = limoCampMapper.selectByExample(null);
        List<CampDto> campDtos = new ArrayList<>();
        CampDto campDto=null;
        for (LimoCamp limoCamp:limoCamps) {
            campDto=new CampDto();
            BeanUtils.copyProperties(limoCamp,campDto);
            campDtos.add(campDto);
        }
        return campDtos;
    }
}
