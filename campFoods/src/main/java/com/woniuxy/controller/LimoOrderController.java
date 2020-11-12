package com.woniuxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoOrder;
import com.woniuxy.param.OrderParam;
import com.woniuxy.param.OrdersParam;
import com.woniuxy.service.LimoOrderService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
@Controller
@RequestMapping("/order")
public class LimoOrderController {
    @Autowired
    private LimoOrderService limoOrderService;

    /**
     * 生成订单
     * @param orders
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertOrder")
    public JSONResult insertOrder(@RequestBody OrdersParam orders)throws Exception{
        limoOrderService.insertOrder(orders);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 查询用户订单信息
     * @param orderParam
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectOrders")
    public JSONResult selectOrders(OrderParam orderParam)throws Exception{
        Page<LimoOrder> page = new Page<>(orderParam.getPageNum(),orderParam.getPageSize());
        QueryWrapper<LimoOrder> queryWrapper = new QueryWrapper<>();
        limoOrderService.page(page,queryWrapper);
        return new JSONResult("200","success",limoOrderService.selectOrders(orderParam),page);
    }

}

