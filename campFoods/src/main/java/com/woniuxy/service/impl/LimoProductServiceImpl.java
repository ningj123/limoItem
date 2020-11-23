package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.dto.ProductDto;
import com.woniuxy.mapper.LimoProductMapper;
import com.woniuxy.param.ProductParam;
import com.woniuxy.service.LimoProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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
    @Resource
    private LimoProductMapper limoProductMapper;

    /**
     * 分页条件查询商品
     * @param productParam
     * @return
     * @throws Exception
     */
    @Override
    public Page<ProductDto> selectProduct(ProductParam productParam) throws Exception {
        Page<LimoProduct> page = new Page<>(productParam.getPageNum(),productParam.getPageSize());
        QueryWrapper<LimoProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_type",productParam.getPType()).eq("p_status",0);
        if(!StringUtils.isEmpty(productParam.getCCity())){
            queryWrapper.eq("c_city",productParam.getCCity());
        }
        if(productParam.getCId()!=null){
            queryWrapper.eq("c_id",productParam.getCId());
        }
        if(productParam.getUrId()!=null){
            queryWrapper.eq("ur_id",productParam.getUrId());
        }
        limoProductMapper.selectPage(page,queryWrapper);
        Page<ProductDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(page,dtoPage);
        return dtoPage;
    }

    /**
     * 查询该城市的推荐商品
     * @param city
     * @param pType
     * @return
     * @throws Exception
     */
    @Override
    public List<ProductDto> recommendProduct(String city, Integer pType) throws Exception {
        QueryWrapper<LimoProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c_city",city).eq("p_type",pType);
        List<LimoProduct> list = limoProductMapper.selectList(queryWrapper);
        List<ProductDto> productDtos = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(list.get(i),productDto);
            productDtos.add(productDto);
            if (i==4){
                break;
            }
        }
        return productDtos;
    }

    @Override
    public Page<ProductDto> selectProductByPName(ProductParam productParam) throws Exception {
        Page<LimoProduct> page = new Page<>(productParam.getPageNum(),productParam.getPageSize());
        QueryWrapper<LimoProduct> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(productParam.getPName())){
            queryWrapper.like("p_name",productParam.getPName());
        }
        limoProductMapper.selectPage(page,queryWrapper);
        Page<ProductDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(page,dtoPage);
        return dtoPage;
    }
}
