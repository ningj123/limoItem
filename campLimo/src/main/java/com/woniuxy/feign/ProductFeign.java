package com.woniuxy.feign;

import com.woniuxy.param.MyProductParam;
import com.woniuxy.util.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ProductFeign
 * @Author shadow
 * @Date 2020/11/9 15:36
 * @Description TODO
 **/
@FeignClient("campFoods")
public interface ProductFeign {
    /**
     * 查询所有商品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("product/selectProduct")
    public JSONResult selectProductByCid(@SpringQueryMap MyProductParam product)throws Exception;

    /**
     * 房车或特色住宿或可以购买房车的信息
     * @param pId
     * @return
     * @throws Exception
     */
    @RequestMapping("product/selectProductById")
    public JSONResult selectProductById(@RequestParam("pId") Integer pId)throws Exception;
    /**
     * 查询订单中该房车未使用的时间
     * @param pId
     * @return
     * @throws Exception
     */
     @GetMapping("limoOrderDetail/selectOrderDetailByPid")
     public JSONResult selectOrderDetailByPid(@RequestParam("pId") Integer pId) throws Exception;
}
