package com.woniuxy.controller;

import com.woniuxy.param.LimoUser;
import com.woniuxy.param.OrderParam;
import com.woniuxy.service.OrderService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
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
        String token = ra.getRequest().getHeader("x-token");*/
        LimoUser user = LoginUtil.parseToken("eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MDU5MjY0OTN9.v-VRblKoWd-RqyCxnNTIKVoXgAiEdysn_pLGfTjcd6__Ru7B98-8e9oYGaqirPhmrK5hhw8Ex3tPcLDhyFYFkQ", LimoUser.class);
        System.out.println(user);
//        Integer uId=1;
//        orderService.insertOrder(orderParam,uId);
        return new JSONResult("200","success",null,null);
    }
}
