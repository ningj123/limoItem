package com.woniuxy.client;

import com.woniuxy.doman.LimoOrder;
import com.woniuxy.param.OrdersParam;
import com.woniuxy.util.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("campFoods")
public interface OrderClient {

    @RequestMapping("insertOrder")
    public JSONResult insertOrder(@SpringQueryMap @RequestBody OrdersParam orders);

}
