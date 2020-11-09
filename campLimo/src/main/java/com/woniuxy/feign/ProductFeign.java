package com.woniuxy.feign;

import com.woniuxy.param.ProductParam;
import com.woniuxy.util.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ProductFeign
 * @Author shadow
 * @Date 2020/11/9 15:36
 * @Description TODO
 **/
@FeignClient("food")
@Component
public interface ProductFeign {
    @RequestMapping("product/selectProductByCid")
    public String selectProductByCid(ProductParam product)throws Exception;
}
