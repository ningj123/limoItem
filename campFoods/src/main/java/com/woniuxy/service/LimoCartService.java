package com.woniuxy.service;

import com.woniuxy.domain.LimoCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.CartParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
public interface LimoCartService extends IService<LimoCart> {
    /**
     * 新增购物车
     * @param cartParam
     * @throws Exception
     */
    public void insertCart(CartParam cartParam)throws Exception;

}
