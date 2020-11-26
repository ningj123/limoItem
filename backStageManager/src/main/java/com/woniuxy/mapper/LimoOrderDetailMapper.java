package com.woniuxy.mapper;

import com.woniuxy.doman.LimoOrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.param.OrderDetailParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-25
 */
public interface LimoOrderDetailMapper extends BaseMapper<LimoOrderDetail> {
    //根据用户id查询订单详情表
    @Select("SELECT o.o_id,o.o_time,o.o_status,o.o_total,o.c_id,od.a_id,od.p_id,od.p_num,od.p_price,od.or_id " +
            "FROM limo_order_detail od JOIN limo_order o on od.o_id=o.o_id WHERE o.u_id=#{uid}")
    public List<OrderDetailParam> selectOrderDetailByUid(Integer uid)throws Exception;

    //根据订单状态查询订单
    @Select("SELECT o.o_id,o.o_time,o.o_status,o.o_total,o.c_id,od.a_id,od.p_id,od.p_num,od.p_price,od.or_id " +
            "FROM limo_order_detail od JOIN limo_order o on od.o_id=o.o_id WHERE o.o_status=#{status}")
    public List<OrderDetailParam> selectOrderByStatus(Integer status)throws Exception;
}
