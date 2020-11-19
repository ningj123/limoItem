package com.woniuxy.client;

import com.woniuxy.util.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuyuli
 * @description: fengin
 * @date: 2020/11/17 9:21
 */
@FeignClient("camp")
public interface CampClient {

    @RequestMapping("limo/camp/selectCampById")
    public JSONResult selectCampById(@RequestParam("id") Integer id)throws Exception;
}
