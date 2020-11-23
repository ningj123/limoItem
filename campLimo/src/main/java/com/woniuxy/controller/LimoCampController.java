package com.woniuxy.controller;

import com.alibaba.fastjson.JSON;
import com.woniuxy.feign.ProductFeign;
import com.woniuxy.param.MyProductParam;
import com.woniuxy.service.CampService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shadow
 * @since 2020-11-09
 */
@RestController
@RequestMapping("limo/camp")
@Api(tags = "营地住宿模块")
public class LimoCampController {
    @Autowired
    private CampService campService;
    @Resource
    private ProductFeign productFeign;

    /**
     * 根据城市分页查询该城市的营地
     *
     * @param city
     * @param pageVO
     * @return
     * @throws Exception
     */
    @GetMapping("selectCampsByCity")
    @ApiOperation(value = "根据城市分页查询该城市的营地")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", value = "城市名称", dataType = "String",defaultValue = "重庆"),
            @ApiImplicitParam(name = "context", value = "搜索框（营地名）", dataType = "String",defaultValue = ""),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer",defaultValue = "3")
    })
    public JSONResult selectCampsByCity(String city, String context, PageVO pageVO) throws Exception {
        return new JSONResult("200", "success", null, campService.selectCampsByCity(city, context, pageVO));
    }

    /**
     * 查询所有营地地址
     *
     * @return
     * @throws Exception
     */
    @GetMapping("selectCamps")
    @ApiOperation(value = "查询所有营地地址")
    public JSONResult selectCamps() throws Exception {
        return new JSONResult("200", "success", campService.selectCamps(), null);
    }

    /**
     * 根据城市分页查询该城市的营地(feign调用)
     *
     * @param city
     * @param pageVO
     * @return
     * @throws Exception
     */
//    @GetMapping("selectCampsCity")
//    public String selectCampsCity(String city, String context, PageVO pageVO) throws Exception {
//        return JSON.toJSONString(campService.selectCampsByCity(city, context, pageVO));
//    }

    /**
     * 根据营地id查询营地信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("selectCampById")
    @ApiOperation(value = "根据营地id查询营地信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "营地id", dataType = "Integer",defaultValue = "1")
    })
    public JSONResult selectCampById(Integer id) throws Exception {
        return new JSONResult("200", "success", null, campService.selectCampById(id));
    }

    /**
     * 根据营地id查询营地信息(feign调用)
     *
     * @param id
     * @return
     * @throws Exception
     */
    /*@GetMapping("selectCampId")
    public String selectCampId(Integer id) throws Exception {
        return JSON.toJSONString(campService.selectCampById(id));
    }*/

    /**
     * 根据营地id查出不同类型的商品
     *
     * @param product
     * @return
     * @throws Exception
     */
    @GetMapping("selectProductByCid")
    @ApiOperation(value = "根据营地id查出不同类型的商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId", value = "营地id", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pType", value = "商品类型（2房车3特色住宿1工具4可以出售的房车）", dataType = "Integer",defaultValue = "2"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer",defaultValue = "3")
    })
    public JSONResult selectProductByCid(MyProductParam product) throws Exception {
        System.out.println(product);
        JSONResult result = productFeign.selectProduct(product);
        return result;
    }

    /**
     * 房车或特色住宿或可以购买房车的信息
     *
     * @param pId
     * @return
     */
    @GetMapping("selectLimos")
    @ApiOperation(value = "房车或特色住宿或可以购买房车的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pId", value = "商品id", dataType = "Integer",defaultValue = "1")
    })
    public JSONResult selectLimos(Integer pId) throws Exception {
        JSONResult result = productFeign.selectProductById(pId);
        return result;
    }

    /**
     * 查询订单中未使用状态的时间
     *
     * @param pId
     * @return
     * @throws Exception
     */
    @GetMapping("selectOrderTime")
    @ApiOperation(value = "查询订单中未使用状态的时间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pId", value = "订单详情表的商品id", dataType = "Integer",defaultValue = "5")
    })
    public JSONResult selectOrderTime(Integer pId) throws Exception {
        JSONResult result = productFeign.selectOrderDetailByPid(pId);
        return result;
    }

}

