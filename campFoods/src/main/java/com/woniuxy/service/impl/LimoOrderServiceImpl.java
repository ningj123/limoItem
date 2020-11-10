package com.woniuxy.service.impl;

import com.woniuxy.domain.LimoOrder;
import com.woniuxy.domain.LimoOrderDetail;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.mapper.LimoOrderDetailMapper;
import com.woniuxy.mapper.LimoOrderMapper;
import com.woniuxy.mapper.LimoProductMapper;
import com.woniuxy.param.OrdersParam;
import com.woniuxy.param.ProductParam;
import com.woniuxy.service.LimoOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
@Service
public class LimoOrderServiceImpl extends ServiceImpl<LimoOrderMapper, LimoOrder> implements LimoOrderService {
   @Resource
   private LimoOrderMapper limoOrderMapper;
   @Resource
   private LimoProductMapper limoProductMapper;
   @Resource
   private LimoOrderDetailMapper limoOrderDetailMapper;
    /**
     * 新增订单
     * @param orders
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertOrder(OrdersParam orders) throws Exception {

        //生成订单表数据
        LimoOrder limoOrder = new LimoOrder();
        limoOrder.setOTotal(orders.getTotal());
        limoOrder.setCId(orders.getCId());
        limoOrder.setUId(orders.getUId());
        limoOrder.setUrId(orders.getUrId());
        limoOrderMapper.insert(limoOrder);
        //取出orders中的商品信息
        List<ProductParam> list = orders.getProduct();
        for(ProductParam p:list){
            //根据商品编号查询商品的库存量，判断是否充足
            LimoProduct product = limoProductMapper.selectById(p.getPId());
            if(product.getPInven()>=p.getPInven()){
                //商品库存充足，生成订单详情表数据
                LimoOrderDetail limoOrderDetail = new LimoOrderDetail();
                limoOrderDetail.setOId(limoOrder.getOId());
                limoOrderDetail.setPId(p.getPId());
                limoOrderDetail.setPNum(p.getPInven());
                limoOrderDetail.setPPrice(p.getPNewPrice());
                if(p.getPType()==2 || p.getPType()==3){
                    limoOrderDetail.setOrStartTime(orders.getStartTime());
                    limoOrderDetail.setOrEndTime(orders.getEndTime());
                }
                limoOrderDetailMapper.insert(limoOrderDetail);
            }else{
                throw new RuntimeException("商品库存不足");
            }
        }

    }
}
