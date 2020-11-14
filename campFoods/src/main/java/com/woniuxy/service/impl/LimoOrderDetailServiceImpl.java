package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.domain.LimoOrderDetail;
import com.woniuxy.dto.OrderDetailDto;
import com.woniuxy.mapper.LimoOrderDetailMapper;
import com.woniuxy.service.LimoOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
public class LimoOrderDetailServiceImpl extends ServiceImpl<LimoOrderDetailMapper, LimoOrderDetail> implements LimoOrderDetailService {
    @Resource
    private LimoOrderDetailMapper limoOrderDetailMapper;
    @Override
    public List<OrderDetailDto> selectOrderDetailByPid(Integer pId) throws Exception {
        QueryWrapper<LimoOrderDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("p_id",pId).eq("or_type",2).lt("or_status",2);
        List<LimoOrderDetail> limoOrderDetails = limoOrderDetailMapper.selectList(wrapper);
        List<OrderDetailDto>  list=new ArrayList<OrderDetailDto>();
        OrderDetailDto orderDetailDto=null;
        for (LimoOrderDetail limoOrderDetail:limoOrderDetails) {
            orderDetailDto=new OrderDetailDto();
            BeanUtils.copyProperties(limoOrderDetail,orderDetailDto);
            list.add(orderDetailDto);
        }
        return list;
    }
}
