package com.woniuxy.feign;

import com.woniuxy.param.ProductParam;
import com.woniuxy.util.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ProductFeign
 * @Author shadow
 * @Date 2020/11/9 15:36
 * @Description TODO
 **/
@FeignClient("food")
@Component
public interface ProductFeign {
    /**
     * 查询所有商品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("product/selectProductByCid")
    public String selectProductByCid(@RequestBody ProductParam product)throws Exception;

    /**
     * 查询订单中该房车未使用的时间
     * @param pId
     * @return
     * @throws Exception
     */
    @GetMapping("order/selectOrderByPid")
    public String selectOrderByPid(Integer pId) throws Exception;
}
