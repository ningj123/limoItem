package com.woniuxy.service;

import com.woniuxy.param.OrderParam;

/**
 * @ClassName OrderService
 * @Author shadow
 * @Date 2020/11/10 11:40
 * @Description TODO
 **/
public interface OrderService {
    void insertOrder(OrderParam orderParam,Integer uId) throws Exception;
}
