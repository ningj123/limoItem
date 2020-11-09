package com.woniuxy.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.param.ProductParam;
import com.woniuxy.service.LimoProductService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
@RestController
@RequestMapping("/product")
public class LimoProductController {
    @Autowired
    private LimoProductService limoProductService;

    /**
     * 分页条件查询商品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectProduct")
    public JSONResult selectProduct(ProductParam product)throws Exception{
        Page<LimoProduct> page = new Page<>(product.getPageNum(), product.getPageSize());
        QueryWrapper<LimoProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_type",product.getPType());
        if(!StringUtils.isEmpty(product.getCCity())){
            queryWrapper.eq("c_city",product.getCCity());
        }
        if(product.getCId()!=null){
            queryWrapper.eq("c_id",product.getCId());
        }
        if(!StringUtils.isEmpty(product.getPName())){
            queryWrapper.like("p_name",product.getPName());
        }
        if(product.getUrId()!=null){
            queryWrapper.eq("ur_id",product.getUrId());
        }
        limoProductService.page(page,queryWrapper);
        return new JSONResult("200","success",null,page);
    }
    /**
     * 分页条件查询商品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectProductByCid")
    public String selectProductByCid(@RequestBody ProductParam product)throws Exception{
        System.out.println(product);
        Page<LimoProduct> page = new Page<>(product.getPageNum(), product.getPageSize());
        QueryWrapper<LimoProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_type",product.getPType());
        if(!StringUtils.isEmpty(product.getCCity())){
            queryWrapper.eq("c_city",product.getCCity());
        }
        if(product.getCId()!=null){
            queryWrapper.eq("c_id",product.getCId());
        }
        if(!StringUtils.isEmpty(product.getPName())){
            queryWrapper.like("p_name",product.getPName());
        }
        if(product.getUrId()!=null){
            queryWrapper.eq("ur_id",product.getUrId());
        }
        limoProductService.page(page,queryWrapper);
        return JSON.toJSONString(page);
    }

    /**
     * 查询单个商品信息
     * @param pId
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectProductById")
   public JSONResult selectProductById(Integer pId)throws Exception{
        return new JSONResult("200","success",null,limoProductService.getById(pId));
   }

}

