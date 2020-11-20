package com.woniuxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.domain.LimoUser;
import com.woniuxy.service.LimoUserService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import com.woniuxy.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.util.JAXBSource;
import java.util.HashMap;
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
@RequestMapping("/user")
@Api(value ="用户模块" )
public class LimoUserController {
    @Autowired
    private LimoUserService limoUserService;

    /**
     * 根据用户编号查询用户信息
     * @param uId
     * @return
     * @throws Exception
     */
    @GetMapping("/selectCampById")
    @ApiOperation(value = "根据用户编号查询用户信息")
    public JSONResult selectUserById(Integer uId)throws Exception{
        return new JSONResult("200","success",null,limoUserService.getById(uId));
    }

}

