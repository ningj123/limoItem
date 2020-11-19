package com.woniuxy.client;

import com.woniuxy.util.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("travel")
public interface BannerFeignClient {
    @GetMapping("/selectByType")
    public JSONResult queryBannerByType(@RequestParam("type") Integer type)throws Exception ;
}
