package com.woniuxy.client;

import com.woniuxy.config.FeginConfiguration;
import com.woniuxy.param.EvaluateParam;
import com.woniuxy.param.OrdersParam;
import com.woniuxy.util.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "campFoods",configuration = FeginConfiguration.class)
public interface OrderClient {

    //新增订单
    @PostMapping("/order/insertOrder")
    public JSONResult insertOrder(@RequestBody OrdersParam orders, @RequestHeader("x-token")String token)throws Exception;

    //新增评价
    @PostMapping("/evaluate/insertEvaluate")
    public JSONResult insertEvaluate(@SpringQueryMap EvaluateParam evaluateParam,@RequestHeader("x-token")String token)throws Exception;

}
