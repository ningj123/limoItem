package com.woniuxy.controller;


import com.woniuxy.param.CartParam;
import com.woniuxy.service.LimoCartService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(value = "购物车模块")
public class LimoCartController {
    @Autowired
    private LimoCartService limoCartService;

    /**
     * 添加到购物车
     * @param cartParam
     * @return
     * @throws Exception
     */
    @PostMapping("/insertCart")
    @ApiOperation(value = "新增购物车数据")
    public JSONResult insertCard(@RequestHeader("x-token")String token, CartParam cartParam)throws Exception{
        Map<String, Object> map = LoginUtil.parseToken(token);
        cartParam.setUId((Integer) map.get("id"));
        limoCartService.insertCart(cartParam);
        return new JSONResult("200","success",null,null);
    }
}

