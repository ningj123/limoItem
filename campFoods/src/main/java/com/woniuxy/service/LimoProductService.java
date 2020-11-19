package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.ProductDto;
import com.woniuxy.param.ProductParam;
import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;

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
    /**
     * 条件分页查询
     * @param productParam
     * @return
     * @throws Exception
     */
    Page<ProductDto> selectProduct(ProductParam productParam)throws Exception;

    /**
     * 查询该城市的推荐商品
     * @param city
     * @param pType
     * @return
     * @throws Exception
     */
    public List<ProductDto> recommendProduct(String city, Integer pType)throws Exception;

    /**
     * 条件查询商品
     * @return
     * @throws Exception
     */
    public Page<ProductDto> selectProductByPName(ProductParam productParam)throws Exception;
}
