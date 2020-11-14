package com.woniuxy.service;

import com.woniuxy.domain.LimoOrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.OrderDetailDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
public interface LimoOrderDetailService extends IService<LimoOrderDetail> {
    List<OrderDetailDto> selectOrderDetailByPid(Integer pId) throws Exception;
}
