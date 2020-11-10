package com.woniuxy.controller;


import com.woniuxy.param.OrdersParam;
import com.woniuxy.service.LimoOrderService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyuli
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
    public JSONResult insertOrder(OrdersParam orders)throws Exception{

        return new JSONResult("200","success",null,null);
    }

}

