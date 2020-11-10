package com.woniuxy.service.impl;

import com.woniuxy.domain.LimoOrder;
import com.woniuxy.domain.LimoOrderDetail;
import com.woniuxy.exception.ErrorException;
import com.woniuxy.mapper.LimoOrderDetailMapper;
import com.woniuxy.mapper.LimoOrderMapper;
import com.woniuxy.param.OrderDetailParam;
import com.woniuxy.param.OrderParam;
import com.woniuxy.service.OrderService;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName OrderServiceImpl
 * @Author shadow
 * @Date 2020/11/10 11:40
 * @Description TODO
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private LimoOrderMapper limoOrderMapper;
    @Resource
    private LimoOrderDetailMapper limoOrderDetailMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Options(useGeneratedKeys=true, keyProperty="limoOrder.oId")
    public void insertOrder(OrderParam orderParam,Integer uId) throws Exception {
        LimoOrder limoOrder = new LimoOrder();
        BeanUtils.copyProperties(orderParam,limoOrder);
        limoOrder.setUId(uId);
        limoOrderMapper.insertSelective(limoOrder);
        LimoOrderDetail limoOrderDetail=null;
        if(limoOrder.getOId()!=null){
            for (OrderDetailParam orderDetailParam:orderParam.getList()) {
                limoOrderDetail=new LimoOrderDetail();
                BeanUtils.copyProperties(orderDetailParam,limoOrderDetail);
                limoOrderDetail.setOId(limoOrder.getOId());
                limoOrderDetailMapper.insertSelective(limoOrderDetail);
            }
        }else{
            throw new ErrorException("新增失败");
        }
    }
}
