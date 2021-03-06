package com.woniuxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.client.OrderClient;
import com.woniuxy.dao.LimoActivityMapper;
import com.woniuxy.doman.*;
import com.woniuxy.dto.*;
import com.woniuxy.param.*;
import com.woniuxy.service.*;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import com.woniuxy.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 营地活动
 * </p>
 *
 * @author cgx
 * @since 2020-11-07
 */
@RestController
@RequestMapping("/campActivities")
@Api(tags = "营地活动接口")
public class LimoActivityController {
    @Autowired
    public LimoActivityService activityService;
    @Autowired
    public LimoActivityMapper activityMapper;
    @Autowired
    public LimoEvaluateService evaluateService;
    @Autowired
    public LimoCollectService collectService;
    @Autowired
    public LimoCartService cartService;
    @Autowired
    public LimoUserService userService;
    @Autowired
    public OrderClient orderClient;


    //从首页传入当前的城市。显示当前城市的营地,并判断当前营地是否为正常状态，正常则显示。
    @GetMapping("selectCamp")
    @ApiOperation("从首页传入当前的城市。显示当前城市的营地")
    @ApiImplicitParam(name = "city", value = "城市名", defaultValue = "重庆")
    public Result selectCamp(String city) throws Exception {
        List<LimoCampDto> limoCampDto = activityService.selectCamp(city);
        if (limoCampDto.size() == 0) {
            return Result.fail(400, "没有该城市的营地", null);
        }
        return Result.success(200, "success", limoCampDto);
    }


    //进入活动首页,根据传过来的当前城市，分页展示当前城市营地活动
    @GetMapping("selectCampActivitiesLimt")
    @ApiOperation("进入活动首页,根据传过来的当前城市，分页展示当前城市营地活动")
    //String city,Integer pageIndex
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ACity", value = "城市名", defaultValue = "重庆"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", defaultValue = "1")
    })
    public Result selectCampActivitiesLimt(@Validated LimoActivityVoParam limoActivityParam, BindingResult bindingResult) throws Exception {
        //参数检验的信息放在bindingResult对象里。
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            return Result.fail(500, "请输入页码", errors);
        }
        QueryWrapper<LimoActivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("a_city", limoActivityParam.getACity());
        Page<LimoActivity> page = activityMapper.selectPage(new Page<LimoActivity>(limoActivityParam.getPageIndex(), 2), queryWrapper);
        if (page.getTotal() == 0) {
            return Result.fail(500, "没有该城市的营地活动", null);
        } else {
            return Result.success(200, "success", page);
        }
//        if (pageIndex==null){
//            return Result.fail(500,"请传入页码",null);
//        }
//        List<LimoActivity> ActivityDto = activityService.selectCampActivitiesLimt(city, pageIndex);
//        if (ActivityDto.size()==0){
//            return Result.fail(500,"没有该城市的营地活动",null);
//        }
    }


    // +1：点击某个营地展示当前营地下的营地活动。
    @GetMapping("selectCampActive")
    @ApiOperation("点击某个营地展示当前营地下的营地活动")
    @ApiImplicitParam(name = "name", value = "当前营地名", defaultValue = "花马山房车露营基地")
    public Result selectCampActive(String name) throws Exception {
        List<LimoActivity> limoActivities = activityService.selectCampActive(name);
        if (limoActivities.size() == 0) {
            return Result.fail(500, "没有该营地下的活动/没有该营地", null);
        }
        return Result.success(200, "success", limoActivities);
    }

    //根据营地活动名称模糊查询具体的营地活动
    @GetMapping("selectCampActivitiesName")
    @ApiOperation("根据营地活动名称模糊查询具体的营地活动")
    @ApiImplicitParam(name = "name", value = "营地活动名称", defaultValue = "夏")
    public Result selectCampActivitiesName(String name) throws Exception {
        QueryWrapper<LimoActivity> queryWrapper = new QueryWrapper<LimoActivity>();
        queryWrapper.like("a_name", name);
        List<LimoActivity> activitiesname = activityService.list(queryWrapper);
        if (activitiesname.size() == 0) {
            return Result.fail(500, "没有该营地活动哦", null);
        }
        return Result.success(200, "success", activitiesname);
    }


    //根据营地活动的分类标签查询活动
    @GetMapping("selectCampActivitiesType")
    @ApiOperation("根据营地活动的分类标签查询活动")
    @ApiImplicitParam(name = "type", value = "营地活动标签类型0/1/2", defaultValue = "0")
    public Result selectCampActivitiesType(Integer type) throws Exception {
        if (type == 0 || type == 1 || type == 2) {
            QueryWrapper<LimoActivity> queryWrapper = new QueryWrapper<LimoActivity>();
            queryWrapper.eq("a_type", type);
            List<LimoActivity> list = activityService.list(queryWrapper);
            return Result.success(200, "success", list);
        } else {
            return Result.fail("无");
        }
    }

    //根据营地活动的门票价格高低排序
    @GetMapping("selectCampActivitiesPrice")
    @ApiOperation("根据营地活动的门票价格高低排序")
    @ApiImplicitParam(name = "priceId", value = "价格高低1/2", defaultValue = "1")
    public Result selectCampActivitiesPrice(Integer priceId) throws Exception {
        QueryWrapper<LimoActivity> queryWrapper = new QueryWrapper<LimoActivity>();
        if (priceId == 1) {
            QueryWrapper<LimoActivity> queryWrapper1 = queryWrapper.orderByAsc("a_price");
            List<LimoActivity> ascPrice = activityService.list(queryWrapper1);
            return Result.success(200, "success", ascPrice);
        } else if (priceId == 2) {
            QueryWrapper<LimoActivity> queryWrapper2 = queryWrapper.orderByDesc("a_price");
            List<LimoActivity> descPrice = activityService.list(queryWrapper2);
            return Result.success(200, "success", descPrice);
        }else {
            return Result.fail("无");
        }
    }

    //进入具体营地活动页面查看营地活动具体详情
    @GetMapping("selectCampActivitiesJuSpecific")
    @ApiOperation("进入具体营地活动页面查看营地活动具体详情")
    @ApiImplicitParam(name = "id", value = "营地活动id", defaultValue = "1")
    public Result selectCampActivitiesJuSpecific(Integer id) throws Exception {
        QueryWrapper<LimoActivity> queryWrapper = new QueryWrapper<LimoActivity>();
        queryWrapper.eq("a_id", id);
        LimoActivity activitytime = activityService.getOne(queryWrapper);
        if (activitytime == null) {
            return Result.fail("没有");
        } else {
            if (activitytime.getAStatus() == 1) {
                return Result.fail("该活动暂未上架，不能操作");
            } else if (activitytime.getAStatus() == 0) {
                return Result.success(200, "success", activitytime);
            } else {
                return Result.fail("没有");
            }
        }
    }

    //查看某营地活动的评论
    @GetMapping("selectCampActivitiesEvaluate")
    @ApiOperation("查看某营地活动的评论")
    @ApiImplicitParam(name = "aid", value = "营地活动id", defaultValue = "2")
    public Result selectCampActivitiesEvaluate(Integer aid) throws Exception {
        QueryWrapper<LimoEvaluate> queryWrapper = new QueryWrapper<LimoEvaluate>();
        queryWrapper.eq("a_id", aid);
        List<LimoEvaluate> list = evaluateService.list(queryWrapper);
        if (list.size()==0 || list==null){
            return Result.fail("没有");
        }
        return Result.success(200, "success", list);
    }

    //收藏营地活动到个人中心
    @GetMapping("insertCampActivitiesCollection")
    @ApiOperation("收藏营地活动到个人中心")
    @ApiImplicitParam(name = "AId", value = "营地活动id", defaultValue = "2")
    public Result insertCampActivitiesCollection(LimoCollectVoParam collectParam, @RequestHeader("x-token") String token) throws Exception {
        LimoCollect limoCollect = new LimoCollect();
        BeanUtils.copyProperties(collectParam, limoCollect);
        //先查询某活动属于哪个营地
        LimoCollectDto selectcid = activityService.selectActivesBelongToCamp(collectParam.getAId());
        Map<String, Object> map = LoginUtil.parseToken(token);
        limoCollect.setuId((Integer) map.get("uId"));
        Integer cId = selectcid.getCId();
        limoCollect.setcId(cId);
        boolean save = collectService.save(limoCollect);
        return Result.success(200, "收藏成功", save);
    }

    //营地活动加入购物车
    @GetMapping("insertCampActivitiesCar")
    @ApiOperation("营地活动加入购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AId", value = "营地活动id", defaultValue = "1"),
            @ApiImplicitParam(name = "PNum", value = "购买数量", defaultValue = "10")
    })
    public Result insertCampActivitiesCar(LimoCartVoParam limoCartParam, @RequestHeader("x-token") String token) throws Exception {
        LimoCart limoCart = new LimoCart();
        BeanUtils.copyProperties(limoCartParam, limoCart);
        Map<String, Object> map = LoginUtil.parseToken(token);
        limoCart.setuId((Integer) map.get("uId"));
        boolean save = cartService.save(limoCart);
        return Result.success(200, "加入购物车成功", save);
    }

    //联系客服
//    @GetMapping("selectCampCustomerService")
//    @ApiOperation("联系客服")
//    public Result selectCampCustomerService() throws Exception {
//        //前端写
//        //<a href="tel:158****5689" >直接拨号</a>
//        return null;
//    }

    //立即购买当前营地活动门票，下订单
    @PostMapping("CampActivitiesDownOrder")
    @ApiOperation("立即购买当前营地活动门票，下订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid", value = "营地id", defaultValue = "1"),
            @ApiImplicitParam(name = "aid", value = "营地活动id", defaultValue = "1"),
            @ApiImplicitParam(name = "num", value = "购买数量", defaultValue = "2"),
            @ApiImplicitParam(name = "price", value = "单价", defaultValue = "110"),
            @ApiImplicitParam(name = "total", value = "总价", defaultValue = "220"),
    })
    public JSONResult CampActivitiesDownOrder(@RequestBody OrdersParam orders, @RequestHeader("x-token") String token) throws Exception {
        System.out.println("====================");
        JSONResult jsonResult = orderClient.insertOrder(orders, token);
        return jsonResult;
    }

    //新增评论
    @PostMapping("insertEvaluate")
    @ApiOperation("新增评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Aid", value = "营地活动id", defaultValue = "1"),
            @ApiImplicitParam(name = "evDes", value = "评论内容", defaultValue = "想要成为rapstar嘛"),
            @ApiImplicitParam(name = "x-token", value = "令牌,取用户id"),
    })
    public JSONResult insertEvaluate(EvaluateParam evaluateParam, @RequestHeader("x-token") String token) throws Exception {
        JSONResult jsonResult = orderClient.insertEvaluate(evaluateParam, token);
        System.out.println(jsonResult + "---------------------");
        return jsonResult;
    }


    //查看当前用户购物车
//    @GetMapping("selectUserCar")
//    @ApiOperation("查看当前用户购物车")
//    @ApiImplicitParam(name = "uid",value = "用户id")
//    public Result selectUserCar(Integer uid) throws Exception {
//        QueryWrapper<LimoCart> limoCartQueryWrapper = new QueryWrapper<>();
//        limoCartQueryWrapper.eq("u_id", uid);
//        LimoCart selectuid = cartService.getOne(limoCartQueryWrapper);
//        if (selectuid == null) {
//            return Result.fail(500, "没有该记录", null);
//        }
//        return Result.success(200, "success", selectuid);
//    }

    //用户登录
//    @GetMapping("selectUserLogin")
//    @ApiOperation("用户登录")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "phone",value = "用户电话"),
//            @ApiImplicitParam(name = "password",value = "用户密码"),
//    })
//    public Result selectUserLogin(String phone, String password) throws Exception {
//        QueryWrapper<LimoUser> limoUserDtoQueryWrapper = new QueryWrapper<>();
//        limoUserDtoQueryWrapper.eq("u_phone", phone);
//        LimoUser user = userService.getOne(limoUserDtoQueryWrapper);
//        if (user == null || phone.isEmpty()) {
//            return Result.fail("用户名错误/用户名不存在");
//        }
//        if (password == null || !password.equals(user.getuPassword())) {
//            return Result.fail("密码错误");
//        }
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("uId", user.getuId());
//        map.put("uName", user.getuName());
//        map.put("uEmail",user.getuEmail());
//
//        String token = LoginUtil.createToken(map, 7 * 24 * 60 * 60);
//        Map<String, Object> stringObjectMap = LoginUtil.parseToken(token);
//        System.out.println(stringObjectMap+"111111111111111111");
//        return Result.success(200, "success", token);
//    }

    //用户注册
//    @GetMapping("insertUserRegister")
//    @ApiOperation("用户注册")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "UPhone",value = "注册电话"),
//            @ApiImplicitParam(name = "UPassword",value = "注册密码"),
//            @ApiImplicitParam(name = "code",value = "验证码"),
//    })
//    public Result insertUserRegister(@Validated LimoUserParam userParam, String code,BindingResult bindingResult) throws Exception {
//        //参数检验的信息放在bindingResult对象里。
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            return Result.fail(500, "必须要输入账号/密码", errors);
//        }
//        LimoUser limoUser = new LimoUser();
//        BeanUtils.copyProperties(userParam,limoUser);
//        if (code.equals(redisTemplate.opsForValue().get(userParam.getUPhone()))) {
//            boolean save = userService.save(limoUser);
//            return Result.success(200,"注册成功",save);
//        } else {
//            return Result.fail("验证码不正确");
//        }
//    }

//    @PostMapping("/getCode")
//    @ApiOperation("获取验证码")
//    @ApiImplicitParam(name = "phone",value = "发送验证码的手机")
//    public Result bsGetCode(String phone) {
//        QueryWrapper<LimoUser> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.eq("u_phone", phone);
//        LimoUser one = userService.getOne(userQueryWrapper);
//        MessageHandler messageHandler = new MessageHandler();
//        //生成动态验证码并存入redis中
//        String code = ((int) ((Math.random() * 9 + 1) * 100000)) + "";
//        HashMap<String, Object> param = new HashMap<>();
//        param.put("code", code);
//        if (one != null) {
//            return Result.fail("该手机已经被注册");
//        } else {
//            //发送短信    "SMS_204297678"是已经自定义的项目短信模板，写死
//            boolean isSend = messageHandler.send(phone, "SMS_205455937", param);
//            if (isSend) {
//                //存入redis（可以用redis暂存，校验
//                redisTemplate.opsForValue().set(phone, code, 300, TimeUnit.SECONDS);
//                return Result.success(200, "执行成功", code);
//            } else {
//                return Result.fail(500,"不能不填哦",null);
//            }
//        }
//    }
}