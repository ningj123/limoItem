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
    public PageInfo<CampDto> selectCampsByCity(String city, PageVO pageVO) throws Exception {
        LimoCampExample example = new LimoCampExample();
        example.createCriteria().andCCityLike(city);
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        List<LimoCamp> list = limoCampMapper.selectByExample(example);
        List<CampDto> campDtos = new ArrayList<>();
        CampDto campDto=null;
        for (LimoCamp limoCamp:list) {
            campDto=new CampDto();
            BeanUtils.copyProperties(limoCamp,campDto);
            campDtos.add(campDto);
        }
        PageInfo<CampDto> pageInfo = new PageInfo<CampDto>(campDtos);
        return pageInfo;
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
}
