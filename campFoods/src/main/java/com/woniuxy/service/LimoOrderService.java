package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.OrderDto;
import com.woniuxy.param.OrderParam;
import com.woniuxy.param.OrdersParam;

import java.util.List;
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

    /**
     * 查询订单信息
     * @param orderParam
     * @return
     * @throws Exception
     */
    public Page<OrderDto> selectOrders(OrderParam orderParam)throws Exception;
    void test();

}
