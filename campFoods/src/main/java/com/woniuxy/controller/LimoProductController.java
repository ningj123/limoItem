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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(value = "商品模块")
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

    @GetMapping("/selectProduct")
    @ApiOperation(value = "查询商品")
    public JSONResult selectProduct(ProductParam product)throws Exception{
        System.out.println(product);
        return new JSONResult("200","success",null,limoProductService.selectProduct(product));
    }

    /**
     * 根据搜索框输入内容进行查询
     * @return
     * @throws Exception
     */
    @GetMapping("/selectProductByPName")
    @ApiOperation(value = "搜索商品")
    public JSONResult selectProductByPName(ProductParam productParam)throws Exception{

        return new JSONResult("200","success",null,limoProductService.selectProductByPName(productParam));
    }

    /**
     * 查询单个商品信息
     * @param pId
     * @return
     * @throws Exception
     */
    @GetMapping("/selectProductById")
    @ApiOperation(value = "查询单个商品的详细信息")
   public JSONResult selectProductById(Integer pId)throws Exception{
        return new JSONResult("200","success",null,limoProductService.getById(pId));
   }

    /**
     * 查询对应城市的所有营地
     * @param camp
     * @return
     * @throws Exception
     */
   @GetMapping("/selectCampByCity")
   @ApiOperation(value = "查询该城市的营地信息")
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
    @GetMapping("/recommend")
    @ApiOperation(value = "查询该城市的推荐商品")
    public JSONResult recommendProduct(String city,Integer pType)throws Exception{
        return new JSONResult("200","success",limoProductService.recommendProduct(city,pType),null);
    }


}

