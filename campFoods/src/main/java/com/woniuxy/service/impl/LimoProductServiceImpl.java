package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.dto.ProductDto;
import com.woniuxy.mapper.LimoProductMapper;
import com.woniuxy.service.LimoProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
@Service
public class LimoProductServiceImpl extends ServiceImpl<LimoProductMapper, LimoProduct> implements LimoProductService {
    @Autowired
    private LimoProductMapper limoProductMapper;
    @Override
    public List<ProductDto> recommendProduct(String city, Integer pType) throws Exception {
        QueryWrapper<LimoProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c_city",city).eq("p_type",pType);
        List<LimoProduct> list = limoProductMapper.selectList(queryWrapper);
        List<ProductDto> productDtos = new ArrayList<>();
        for(LimoProduct pro:list){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(pro,productDto);
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
