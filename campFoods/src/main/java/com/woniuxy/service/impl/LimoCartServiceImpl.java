package com.woniuxy.service.impl;

import com.woniuxy.domain.LimoCart;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.mapper.LimoCartMapper;
import com.woniuxy.mapper.LimoProductMapper;
import com.woniuxy.param.CartParam;
import com.woniuxy.service.LimoCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@Service
public class LimoCartServiceImpl extends ServiceImpl<LimoCartMapper, LimoCart> implements LimoCartService {
    @Resource
    private LimoCartMapper limoCartMapper;
    @Resource
    private LimoProductMapper limoProductMapper;
    /**
     *  添加商品到购物车
     * @param cartParam
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertCart(CartParam cartParam) throws Exception {
        LimoProduct product = limoProductMapper.selectById(cartParam.getPId());
        if (product.getPStatus()!=0){
            throw new RuntimeException("该商品已下架");
        }
        LimoCart limoCart = new LimoCart();
        BeanUtils.copyProperties(cartParam,limoCart);
        limoCartMapper.insert(limoCart);
    }
}
