package com.woniuxy.service;

import com.woniuxy.domain.LimoOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.OrdersParam;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
public interface LimoOrderService extends IService<LimoOrder> {
    /**
     * 新增订单
     * @param orders
     * @throws Exception
     */
    public void insertOrder(OrdersParam orders)throws Exception;

}
