package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.annotation.RedisLock;
import com.woniuxy.domain.*;
import com.woniuxy.dto.ActivityDto;
import com.woniuxy.dto.OrderDetailDto;
import com.woniuxy.dto.OrderDto;
import com.woniuxy.dto.ProductDto;
import com.woniuxy.mapper.*;
import com.woniuxy.param.OrderDetailsParam;
import com.woniuxy.param.OrderParam;
import com.woniuxy.param.OrdersParam;
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
   @Resource
   private LimoCartMapper limoCartMapper;
    /**
     * 新增订单
     * @param orders
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @RedisLock(key = "order")
    public void insertOrder(OrdersParam orders) throws Exception {
        //生成订单表数据
        LimoOrder limoOrder = new LimoOrder();
        limoOrder.setOTotal(orders.getTotal());
        limoOrder.setCId(orders.getCId());
        limoOrder.setUId(orders.getUId());
        limoOrder.setUrId(orders.getUrId());
        limoOrderMapper.insert(limoOrder);
        //取出orders中的商品信息
        List<OrderDetailsParam> list = orders.getOrderDetailsParams();
        for(OrderDetailsParam p:list){
            //根据商品编号查询商品的库存量，判断是否充足
            int update=0;
            if(p.getPId()!=null && p.getPId()>0){
                LimoProduct product1 = new LimoProduct();
                LimoProduct product = limoProductMapper.selectById(p.getPId());
                product1.setPId(p.getPId());
                product1.setPInven(product.getPInven()-p.getNum());
                UpdateWrapper<LimoProduct> updateWrapper = new UpdateWrapper<>();
                updateWrapper.ge("p_inven",p.getNum());
                update = limoProductMapper.update(product1, updateWrapper);
            }
            if(p.getAId()!=null&&p.getAId()>0){
                LimoActivity limoActivity = new LimoActivity();
                LimoActivity activity = limoActivityMapper.selectById(p.getAId());
                limoActivity.setAId(activity.getAId());
                limoActivity.setAInven(activity.getAInven()-p.getNum());
                UpdateWrapper<LimoActivity> updateWrapper = new UpdateWrapper<>();
                updateWrapper.ge("a_inven",p.getNum());
                update = limoActivityMapper.update(limoActivity, updateWrapper);
            }
            if(update>0){
                //商品库存充足，生成订单详情表数据
                LimoOrderDetail limoOrderDetail = new LimoOrderDetail();
                limoOrderDetail.setOId(limoOrder.getOId());
                limoOrderDetail.setPId(p.getPId());
                limoOrderDetail.setPNum(p.getNum());
                limoOrderDetail.setPPrice(p.getPrice());
                limoOrderDetail.setOrType(0);
                limoOrderDetail.setOrStartTime(p.getStartTime());
                limoOrderDetail.setOrEndTime(p.getEndTime());
                limoOrderDetailMapper.insert(limoOrderDetail);
            }else{
                throw new RuntimeException("商品库存不足");
            }
        }
        if (orders.getCaId()!=null && orders.getCaId()>0){
            LimoCart limoCart = new LimoCart();
            limoCart.setCaId(orders.getCaId());
            limoCart.setCaStatus(1);
            limoCartMapper.updateById(limoCart);
        }

    }

    /**
     * 查询用户订单信息
     * @param orderParam
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<OrderDto> selectOrders(OrderParam orderParam) throws Exception {
        Page<LimoOrder> page = new Page<>(orderParam.getPageNum(),orderParam.getPageSize());
        //查询用户的订单信息
        QueryWrapper<LimoOrder> queryWrapper = new QueryWrapper<>();
        if (orderParam.getOId()!=null && orderParam.getOId()>0){
            queryWrapper.eq("o_id",orderParam.getOId());
        }
        if (orderParam.getUId()!=null&&orderParam.getUId()>0){
            queryWrapper.eq("u_id",orderParam.getUId());
        }
        if(orderParam.getOStatus()!=null){
            queryWrapper.eq("o_status",orderParam.getOStatus());
        }
        limoOrderMapper.selectPage(page,queryWrapper);
        ArrayList<OrderDto> orderDtos = new ArrayList<>();
        List<LimoOrder> limoOrders = page.getRecords();
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
                if (ld.getPId()!=null && ld.getPId()>0){
                    //查询商品信息
                    LimoProduct product = limoProductMapper.selectById(ld.getPId());
                    ProductDto productDto = new ProductDto();
                    BeanUtils.copyProperties(product,productDto);
                    orderDetailDto.setProductDto(productDto);
                }
                if(ld.getAId()!=null && ld.getAId()>0){
                    //查询活动信息
                    LimoActivity limoActivity = limoActivityMapper.selectById(ld.getAId());
                    ActivityDto activityDto = new ActivityDto();
                    BeanUtils.copyProperties(limoActivity,activityDto);
                    orderDetailDto.setActivityDto(activityDto);
                }
            }
            orderDtos.add(orderDto);
        }
        Page<OrderDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(page,dtoPage);
        dtoPage.setRecords(orderDtos);
        return dtoPage;
    }
}
