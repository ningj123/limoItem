package com.woniuxy.service.impl;

import com.woniuxy.doman.LimoOrderDetail;
import com.woniuxy.mapper.LimoOrderDetailMapper;
import com.woniuxy.param.OrderDetailParam;
import com.woniuxy.service.LimoOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-25
 */
@Service
public class LimoOrderDetailServiceImpl extends ServiceImpl<LimoOrderDetailMapper, LimoOrderDetail> implements LimoOrderDetailService {
    @Autowired
    public LimoOrderDetailMapper orderDetailMapper;
    //根据用户id查询订单详情表
    @Override
    public List<OrderDetailParam> selectOrderDetailByUid(Integer uid) throws Exception {
        return orderDetailMapper.selectOrderDetailByUid(uid);
    }
    //根据订单状态查询订单
    public List<OrderDetailParam> selectOrderByStatus(Integer status)throws Exception{
        return orderDetailMapper.selectOrderByStatus(status);
    }
}
