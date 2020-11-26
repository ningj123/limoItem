package com.woniuxy.controller;


import com.woniuxy.util.MD5Util;
import com.woniuxy.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cgx
 * @since 2020-11-12
 */
//@RestController
//@RequestMapping("/limoManage")
//@Api(tags = "管理员接口")
public class LimoManageController {

    @GetMapping("manageLogin")
    @ApiOperation("管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",value = "管理员电话",defaultValue = "123456"),
            @ApiImplicitParam(name = "password",value = "管理员密码",defaultValue = "123456")
    })
    public Result manageLogin(String phone, String password) throws Exception {
        //把登陆操作委托给shiro完成
        //密码加密
        String md = MD5Util.MD5EncodeUtf8(password);
        UsernamePasswordToken token = new UsernamePasswordToken(phone, md);
        //调用shiro的login方法
        Subject subject = SecurityUtils.getSubject();
        //在没登陆的情况才进行登陆
        if (!subject.isAuthenticated()){
            subject.login(token);
            return Result.success(200,"登陆成功",null);
        }else {
            return Result.fail(400,"重复登录",null);
        }
    }
}

