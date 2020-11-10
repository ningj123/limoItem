package com.woniuxy.service;

import com.woniuxy.domain.LimoProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.ProductDto;
import com.woniuxy.util.JSONResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
public interface LimoProductService extends IService<LimoProduct> {
    public List<ProductDto> recommendProduct(String city, Integer pType)throws Exception;
}
