package com.woniuxy.utils;

import com.woniuxy.domain.LimoOrder;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.mapper.LimoOrderMapper;
import com.woniuxy.mapper.LimoProductMapper;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RocketMQMessageListener(consumerGroup = "limo-order",consumeMode = ConsumeMode.ORDERLY,topic = "order")
public class MqLister implements RocketMQListener<Integer> {
    @Resource
    private LimoOrderMapper limoOrderMapper;
    @Resource
    private LimoProductMapper limoProductMapper;
    @Override
    public void onMessage(Integer message) {
        LimoOrder limoOrder = limoOrderMapper.selectById(message);
        if (limoOrder.getOStatus()==0){
            //修改订单的状态
            LimoOrder order = LimoOrder.builder().oStatus(4).oId(message).build();
            limoOrderMapper.updateById(order);
        }
    }
}
