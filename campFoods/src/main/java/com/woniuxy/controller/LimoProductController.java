package com.woniuxy.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.client.BannerFeignClient;
import com.woniuxy.domain.LimoCamp;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.param.CampParam;
import com.woniuxy.param.ProductParam;
import com.woniuxy.service.LimoCampService;
import com.woniuxy.service.LimoProductService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private LimoCampService limoCampService;
    @Autowired
    private BannerFeignClient bannerFeignClient;
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
        queryWrapper.eq("p_type",product.getPType()).eq("p_status",0);
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
     * 查询单个商品信息
     * @param pId
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectProductById")
   public JSONResult selectProductById(Integer pId)throws Exception{
        return new JSONResult("200","success",null,limoProductService.getById(pId));
   }

    /**
     * 查询对应城市的所有营地
     * @param camp
     * @return
     * @throws Exception
     */
   @RequestMapping("/selectCampByCity")
    public JSONResult selectCampByCity(CampParam camp)throws Exception{
       Page<LimoCamp> page = new Page<>(camp.getPageNum(),camp.getPageSize());
       QueryWrapper<LimoCamp> queryWrapper = new QueryWrapper<>();
       queryWrapper.eq("c_city",camp.getCCity());
       limoCampService.page(page,queryWrapper);
       return new JSONResult("200","success",null,page);
   }
   @RequestMapping("/selectBanner")
    public JSONResult selectFoodBanner(Integer type)throws Exception{
        return bannerFeignClient.queryBannerByType(type);
   }
    @RequestMapping("/recommend")
    public JSONResult recommendProduct(String city,Integer pType)throws Exception{
        return new JSONResult("200","success",limoProductService.recommendProduct(city,pType),null);
    }

}

