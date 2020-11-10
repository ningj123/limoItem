package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoActivity;
import com.woniuxy.domain.LimoOrder;
import com.woniuxy.domain.LimoOrderDetail;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.dto.ActivityDto;
import com.woniuxy.dto.OrderDetailDto;
import com.woniuxy.dto.OrderDto;
import com.woniuxy.dto.ProductDto;
import com.woniuxy.mapper.LimoActivityMapper;
import com.woniuxy.mapper.LimoOrderDetailMapper;
import com.woniuxy.mapper.LimoOrderMapper;
import com.woniuxy.mapper.LimoProductMapper;
import com.woniuxy.param.OrderParam;
import com.woniuxy.param.OrdersParam;
import com.woniuxy.param.ProductParam;
import com.woniuxy.service.LimoOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
   @Resource
   private LimoActivityMapper limoActivityMapper;
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
            LimoProduct product1 = new LimoProduct();
            LimoProduct product = limoProductMapper.selectById(p.getPId());
            product1.setPId(p.getPId());
            product1.setPInven(product.getPInven()-p.getPInven());
            UpdateWrapper<LimoProduct> updateWrapper = new UpdateWrapper<>();
            updateWrapper.ge("p_inven",0);
            int update = limoProductMapper.update(product1, updateWrapper);
            if(update>0){
                //商品库存充足，生成订单详情表数据
                LimoOrderDetail limoOrderDetail = new LimoOrderDetail();
                limoOrderDetail.setOId(limoOrder.getOId());
                limoOrderDetail.setPId(p.getPId());
                limoOrderDetail.setPNum(p.getPInven());
                limoOrderDetail.setPPrice(p.getPNewPrice());
                limoOrderDetail.setOrType(0);
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

    /**
     * 查询用户订单信息
     * @param orderParam
     * @return
     * @throws Exception
     */
    @Override
    public List<OrderDto> selectOrders(OrderParam orderParam) throws Exception {
        //查询用户的订单信息
        QueryWrapper<LimoOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",orderParam.getUId());
        if(orderParam.getOStatus()!=null){
            queryWrapper.eq("o_status",orderParam.getOStatus());
        }
        ArrayList<OrderDto> orderDtos = new ArrayList<>();
        List<LimoOrder> limoOrders = limoOrderMapper.selectList(queryWrapper);
        for(LimoOrder lo:limoOrders){
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(lo,orderDto);
            orderDto.setOrderDetailDtos(new ArrayList<OrderDetailDto>());
            QueryWrapper<LimoOrderDetail> detailQueryWrapper = new QueryWrapper<>();
            detailQueryWrapper.eq("o_id",lo.getOId());
            //查询用户订单详情
            List<LimoOrderDetail> limoOrderDetails = limoOrderDetailMapper.selectList(detailQueryWrapper);
            for (LimoOrderDetail ld:limoOrderDetails){
                OrderDetailDto orderDetailDto = new OrderDetailDto();
                BeanUtils.copyProperties(ld,orderDetailDto);
                orderDto.getOrderDetailDtos().add(orderDetailDto);
                //判断订单详情类型，0为商品，1为活动
                if (ld.getOrType()==0){
                    //查询商品信息
                    LimoProduct product = limoProductMapper.selectById(ld.getPId());
                    ProductDto productDto = new ProductDto();
                    BeanUtils.copyProperties(product,productDto);
                    orderDetailDto.setProductDto(productDto);
                }
                if(ld.getOrType()==1){
                    //查询活动信息
                    LimoActivity limoActivity = limoActivityMapper.selectById(ld.getPId());
                    ActivityDto activityDto = new ActivityDto();
                    BeanUtils.copyProperties(limoActivity,activityDto);
                    orderDetailDto.setActivityDto(activityDto);
                }
            }
        }
        return orderDtos;
    }
}
