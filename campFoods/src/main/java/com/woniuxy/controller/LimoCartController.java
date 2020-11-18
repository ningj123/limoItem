package com.woniuxy.controller;


import com.woniuxy.domain.LimoUser;
import com.woniuxy.param.CartParam;
import com.woniuxy.service.LimoCartService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/cart")
public class LimoCartController {
    @Autowired
    private LimoCartService limoCartService;

    /**
     * 添加到购物车
     * @param cartParam
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertCart")
    public JSONResult insertCard(@RequestHeader("x-token")String token, CartParam cartParam)throws Exception{
        Map<String, Object> map = LoginUtil.parseToken(token);
        cartParam.setUId((Integer) map.get("id"));
        limoCartService.insertCart(cartParam);
        return new JSONResult("200","success",null,null);
    }
}

