package com.woniuxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.config.MessageHandler;
import com.woniuxy.doman.LimoCart;
import com.woniuxy.doman.LimoUser;
import com.woniuxy.param.LimoUserParam;
import com.woniuxy.service.LimoCartService;
import com.woniuxy.service.LimoUserService;
import com.woniuxy.util.LoginUtil;
import com.woniuxy.util.MD5Util;
import com.woniuxy.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/limoUser")
@Api(tags = "用户接口")
public class LimoUserController {
    @Autowired
    public RedisTemplate<String, String> redisTemplate;
    @Autowired
    public LimoUserService userService;
    @Autowired
    public LimoCartService cartService;

    //用户注册
    @GetMapping("insertUserRegister")
    @ApiOperation("用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UPhone", value = "注册电话", defaultValue = "15223775547"),
            @ApiImplicitParam(name = "UPassword", value = "注册密码", defaultValue = "123456789"),
            @ApiImplicitParam(name = "code", value = "验证码"),
    })
    public Result insertUserRegister(@Validated LimoUserParam userParam, String code) throws Exception {
        LimoUser limoUser = new LimoUser();
        BeanUtils.copyProperties(userParam, limoUser);
        QueryWrapper<LimoUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("u_phone", userParam.getUPhone());
        LimoUser one = userService.getOne(userQueryWrapper);
        if (one != null) {
            return Result.fail("该手机已经被注册");
        } else {
            if (code == null) {
                return Result.fail("验证码不能为空");
            } else {
                //密码加密
                limoUser.setuPassword(MD5Util.MD5EncodeUtf8(userParam.getUPassword()));
                if (code.equals(redisTemplate.opsForValue().get(userParam.getUPhone()))) {
                    boolean save = userService.save(limoUser);
                    return Result.success(200, "注册成功", save);
                } else {
                    return Result.fail("验证码不正确/手机号码");
                }
            }
        }
    }

    @PostMapping("/getCode")
    @ApiOperation("获取验证码")
    @ApiImplicitParam(name = "phone", value = "发送验证码的手机", defaultValue = "15223775547")
    public Result bsGetCode(String phone) {
        if (phone == null || phone.length() != 11) {
            return Result.fail("请输入正确的手机号");
        }
        QueryWrapper<LimoUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("u_phone", phone);
        List<LimoUser> one = userService.list(userQueryWrapper);
        MessageHandler messageHandler = new MessageHandler();
        //生成动态验证码并存入redis中
        String code = ((int) ((Math.random() * 9 + 1) * 100000)) + "";
        HashMap<String, Object> param = new HashMap<>();
        param.put("code", code);
        if (one.size() != 0) {
            return Result.fail("该手机已经被注册/");
        } else {
            //发送短信    "SMS_204297678"是已经自定义的项目短信模板，写死
            boolean isSend = messageHandler.send(phone, "SMS_205455937", param);
            if (isSend) {
                //存入redis（可以用redis暂存，校验
                redisTemplate.opsForValue().set(phone, code, 300, TimeUnit.SECONDS);
                return Result.success(200, "执行成功", code);
            } else {
                return Result.fail(500, "不能不填哦", null);
            }
        }
    }

    //用户登录
    @GetMapping("selectUserLogin")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "用户电话", defaultValue = "15111"),
            @ApiImplicitParam(name = "password", value = "用户密码", defaultValue = "123456"),
    })
    public Result selectUserLogin(String phone, String password) throws Exception {
        QueryWrapper<LimoUser> limoUserDtoQueryWrapper = new QueryWrapper<>();
        limoUserDtoQueryWrapper.eq("u_phone", phone);
        LimoUser user = userService.getOne(limoUserDtoQueryWrapper);
        //密码加密
        String md = MD5Util.MD5EncodeUtf8(password);
        if (user == null || phone.isEmpty()) {
            return Result.fail("用户名错误/用户名不存在");
        }
        if (password == null || !md.equals(user.getuPassword())) {
            return Result.fail("密码错误");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("uId", user.getuId());
        map.put("uName", user.getuName());
        map.put("uEmail", user.getuEmail());

        String token = LoginUtil.createToken(map, 7 * 24 * 60 * 60);
        Map<String, Object> stringObjectMap = LoginUtil.parseToken(token);
        System.out.println(stringObjectMap + "111111111111111111");
        return Result.success(200, "success", token);
    }


    //查看当前用户购物车
    @GetMapping("selectUserCar")
    @ApiOperation("查看当前用户购物车")
    @ApiImplicitParam(name = "phone", value = "用户id", defaultValue = "1")
    public Result selectUserCar(Integer uid) throws Exception {
        QueryWrapper<LimoCart> limoCartQueryWrapper = new QueryWrapper<>();
        limoCartQueryWrapper.eq("u_id", uid);
        List<LimoCart> selectuid = cartService.list(limoCartQueryWrapper);
        if (selectuid == null) {
            return Result.fail(500, "没有该记录", null);
        }
        return Result.success(200, "success", selectuid);
    }


    //用户修改密码
    @GetMapping("updatePassword")
    @ApiOperation("用户修改密码")
    @ApiImplicitParam(name = "phone", value = "用户电话", defaultValue = "1")
    public Result updatePassword(String phone, String password, String newPassword) throws Exception {
        QueryWrapper<LimoUser> limoUserDtoQueryWrapper = new QueryWrapper<>();
        limoUserDtoQueryWrapper.eq("u_phone", phone);
        LimoUser user = userService.getOne(limoUserDtoQueryWrapper);
        if (user == null) {
            return Result.fail("没有该账号");
        }
        if (newPassword==null){
            return Result.fail("新密码不能为空");
        }
        if (phone == null || phone.equals("") || !phone.equals(user.getuPhone())) {
            return Result.fail("请输入正确的电话号码");
        } else {
            if (password == null || password.equals("") || !user.getuPassword().equals(password)) {
                return Result.fail("密码不能为空/输入的旧密码不正确");
            } else {
                if (!password.equals(newPassword)){
                    UpdateWrapper<LimoUser> limoUserUpdateWrapper = new UpdateWrapper<>();
                    limoUserUpdateWrapper.set("u_password", newPassword).eq("u_phone", phone);
                    boolean update = userService.update(limoUserUpdateWrapper);
                    return Result.success(200, "修改成功", update);
                }else {
                    return Result.fail("新密码和旧密码不能相同");
                }
            }
        }
    }
}
