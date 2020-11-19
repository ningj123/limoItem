package com.woniuxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.woniuxy.client.BannerClient;
import com.woniuxy.domain.LimoCamp;
import com.woniuxy.param.CampParam;
import com.woniuxy.param.ProductParam;
import com.woniuxy.service.LimoCampService;
import com.woniuxy.service.LimoProductService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class LimoProductController {
    @Autowired
    private LimoProductService limoProductService;
    @Autowired
    private LimoCampService limoCampService;
//    @Autowired
//    private BannerClient bannerClient;
    /**
     * 分页条件查询商品
     * @param product
     * @return
     * @throws Exception
     */

    @RequestMapping("/selectProduct")
    public JSONResult selectProduct(ProductParam product)throws Exception{
        return new JSONResult("200","success",null,limoProductService.selectProduct(product));
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
//    @RequestMapping("/selectBanner")
//    public JSONResult selectBanner(Integer type)throws Exception{
//        return bannerClient.queryBannerByType(type);
//    }
    /**
     * 查询该城市营地的推荐商品
     * @param city
     * @param pType
     * @return
     * @throws Exception
     */
    @RequestMapping("/recommend")
    public JSONResult recommendProduct(String city,Integer pType)throws Exception{
        return new JSONResult("200","success",limoProductService.recommendProduct(city,pType),null);
    }


}

