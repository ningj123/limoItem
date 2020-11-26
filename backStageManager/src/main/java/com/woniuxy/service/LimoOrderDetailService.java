package com.woniuxy.service;

import com.woniuxy.doman.LimoOrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.OrderDetailParam;
import com.woniuxy.utils.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-25
 */
public interface LimoOrderDetailService extends IService<LimoOrderDetail> {
    //根据用户id查询订单详情表
    public List<OrderDetailParam> selectOrderDetailByUid(Integer uid)throws Exception;
    //根据订单状态查询订单
    public List<OrderDetailParam> selectOrderByStatus(Integer status)throws Exception;

}
