package com.woniuxy.controller;

import com.woniuxy.param.LimoUser;
import com.woniuxy.param.OrderParam;
import com.woniuxy.service.OrderService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName OrderController
 * @Author shadow
 * @Date 2020/11/10 11:38
 * @Description TODO
 **/
@RestController
@RequestMapping("limo/order")
@Api(tags = "营地住宿下单")
public class OrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 新增订单信息，默认未付款
     * @param orderParam
     * @return
     * @throws Exception
     */
    @PostMapping("insertOrder")
    @ApiOperation(value = "营地住宿下单")
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "pId", value = "商品id",required = true,dataType = "Integer",defaultValue = "5"),
            @ApiImplicitParam(name = "pNum", value = "商品数量",required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pPrice", value = "商品单价",required = true, dataType = "double",defaultValue = "2141"),
            @ApiImplicitParam(name = "pTotal", value = "单个商品总价",required = true, dataType = "double",defaultValue = "2141"),
            @ApiImplicitParam(name = "orType", value = "订单类型",required = true, dataType = "Integer",defaultValue = "2"),
            @ApiImplicitParam(name = "orStartTime", value = "房车订单开始时间",required = true, dataType = "String",defaultValue = "2020-11-23"),
            @ApiImplicitParam(name = "orEndTime", value = "房车订单结束时间",required = true, dataType = "String",defaultValue = "2020-11-24"),
            @ApiImplicitParam(name = "oId", value = "订单id",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "uId", value = "用户登录后id",required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "cId", value = "营地id",required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "oTotal", value = "订单总价",required = true, dataType = "double",defaultValue = "2141"),
            @ApiImplicitParam(name = "token", value = "用户登录后的token",required = true, dataType = "String")
    })*/
    public JSONResult insertOrder(@RequestHeader("x-token") String token,@RequestBody OrderParam orderParam) throws Exception{
        /*ServletRequestAttributes ra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = ra.getRequest().getHeader("x-token");*/
        Map<String, Object> map = LoginUtil.parseToken(token);
        System.out.println(map.get("uId"));
        Integer uId=(Integer) map.get("uId");
        orderService.insertOrder(orderParam,uId);
        return new JSONResult("200","success",null,null);
    }
}
