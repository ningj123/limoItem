package com.woniuxy.controller;


import com.woniuxy.domain.LimoUser;
import com.woniuxy.param.OrderParam;
import com.woniuxy.param.OrdersParam;
import com.woniuxy.service.LimoOrderService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
@RestController
@RequestMapping("/order")
@Api(value = "订单模块")
public class LimoOrderController {
    @Autowired
    private LimoOrderService limoOrderService;

    /**
     * 生成订单
     * @param orders
     * @return
     * @throws Exception
     */
    @PostMapping("/insertOrder")
    @ApiOperation(value = "新增订单")
    public JSONResult insertOrder(@RequestBody @RequestHeader("x-token")String token, OrdersParam orders)throws Exception{
        Map<String, Object> map = LoginUtil.parseToken(token);
        orders.setUId((Integer) map.get("uId"));
        limoOrderService.insertOrder(orders);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 查询用户订单信息
     * @param orderParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询用户订单")
    @GetMapping("/selectOrders")
    public JSONResult selectOrders(@RequestHeader("x-token")String token,OrderParam orderParam)throws Exception{
        Map<String, Object> map = LoginUtil.parseToken(token);
        orderParam.setUId((Integer) map.get("uId"));
        return new JSONResult("200","success",null,limoOrderService.selectOrders(orderParam));
    }

}

