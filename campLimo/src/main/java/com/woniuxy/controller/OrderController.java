package com.woniuxy.controller;

import com.woniuxy.param.OrderParam;
import com.woniuxy.service.OrderService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Author shadow
 * @Date 2020/11/10 11:38
 * @Description TODO
 **/
@RestController
@RequestMapping("limo/order")
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
    public JSONResult insertOrder(@RequestBody OrderParam orderParam) throws Exception{
        /*ServletRequestAttributes ra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = ra.getRequest().getHeader("shadow-token");
        LimoUser user = LoginUtil.parseToken(token, LimoUser.class);*/
        Integer uId=1;
        orderService.insertOrder(orderParam,uId);
        return new JSONResult("200","success",null,null);
    }
}