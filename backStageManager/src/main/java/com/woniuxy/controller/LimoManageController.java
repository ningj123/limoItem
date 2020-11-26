package com.woniuxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.doman.LimoManage;
import com.woniuxy.doman.LimoOrder;
import com.woniuxy.doman.LimoOrderDetail;
import com.woniuxy.doman.LimoProduct;
import com.woniuxy.param.OrderDetailParam;
import com.woniuxy.service.LimoOrderDetailService;
import com.woniuxy.service.LimoOrderService;
import com.woniuxy.service.LimoProductService;
import com.woniuxy.util.MD5Util;
import com.woniuxy.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/limoManage")
@Api(tags = "管理员接口")
public class LimoManageController {

    @Autowired
    public LimoProductService productService;
    @Autowired
    public LimoOrderService orderService;
    @Autowired
    public LimoOrderDetailService orderDetailService;

    @GetMapping("manageLogin")
    @ApiOperation("管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "管理员电话", defaultValue = "123456"),
            @ApiImplicitParam(name = "password", value = "管理员密码", defaultValue = "123456")
    })
    public Result manageLogin(String phone, String password) throws Exception {
        //把登陆操作委托给shiro完成
        //密码加密
        String md = MD5Util.MD5EncodeUtf8(password);
        System.out.println(md + "-------");
        UsernamePasswordToken token = new UsernamePasswordToken(phone, md);
        //调用shiro的login方法
        Subject subject = SecurityUtils.getSubject();
        //在没登陆的情况才进行登陆
        if (!subject.isAuthenticated()) {
            subject.login(token);
            //取出放入shiro的对象
            LimoManage limoManage = (LimoManage) subject.getPrincipal();
            System.out.println(limoManage + "--------------");
            return Result.success(200, "登陆成功", null);
        } else {
            return Result.fail(400, "重复登录", null);
        }
    }

    //商品的上架，下架。
    //查询订单。
    //查询订单详情,根据订单表id
    //根据用户id查询订单详情表
    //根据订单状态查询订单
    //改变订单状态
    //营地活动的上架，下架。

    //商品的上架
    @GetMapping("ProductDown")
    @ApiOperation("商品的上架")
    @ApiImplicitParam(name = "pid", value = "商品id", defaultValue = "1")
    public Result ProductDown(Integer pid) throws Exception {
        //从shiro中取出当前登录对象
        LimoManage limoManage = (LimoManage) SecurityUtils.getSubject().getPrincipal();
        if (pid == null) {
            return Result.fail("请输入商品");
        }
        if (limoManage == null) {
            return Result.fail("你没登录");
        }
        if (limoManage.getRId() == 1 || limoManage.getRId() == 2) {
            QueryWrapper<LimoProduct> limoProductQueryWrapper = new QueryWrapper<>();
            limoProductQueryWrapper.eq("p_id", pid);
            LimoProduct product = productService.getOne(limoProductQueryWrapper);
            if (product.getPStatus() == 0) {
                return Result.fail("该商品已上架，无需再上架");
            }
            UpdateWrapper<LimoProduct> limoProductUpdateWrapper = new UpdateWrapper<>();
            limoProductUpdateWrapper.set("p_status", 0).eq("p_id", pid);
            boolean update = productService.update(limoProductUpdateWrapper);
            return Result.success(200, "修改成功，商品已上架", update);
        } else {
            return Result.fail("您的权限不足，不能商品上架");
        }
    }

    //商品的下架
    @GetMapping("ProductUp")
    @ApiOperation("商品的下架")
    @ApiImplicitParam(name = "pid", value = "商品id", defaultValue = "1")
    public Result ProductUp(Integer pid) throws Exception {
        LimoManage limoManage = (LimoManage) SecurityUtils.getSubject().getPrincipal();
        if (pid == null) {
            return Result.fail("请输入商品");
        }
        if (limoManage == null) {
            return Result.fail("你没登录");
        }
        if (limoManage.getRId() == 1 || limoManage.getRId() == 2) {
            QueryWrapper<LimoProduct> limoProductQueryWrapper = new QueryWrapper<>();
            limoProductQueryWrapper.eq("p_id", pid);
            LimoProduct product = productService.getOne(limoProductQueryWrapper);
            if (product.getPStatus() == 1) {
                return Result.fail("该商品已下架，无需再下架");
            }
            UpdateWrapper<LimoProduct> limoProductUpdateWrapper = new UpdateWrapper<>();
            limoProductUpdateWrapper.set("p_status", 1).eq("p_id", pid);
            boolean update = productService.update(limoProductUpdateWrapper);
            return Result.success(200, "修改成功，商品已下架", update);
        } else {
            return Result.fail("您的全限不足，不能商品下架");
        }
    }


    //查询订单,展示所有订单表
    @GetMapping("selectOrder")
    @ApiOperation("展示所有订单表")
    public Result selectOrder() throws Exception {
        LimoManage limoManage = (LimoManage) SecurityUtils.getSubject().getPrincipal();
        if (limoManage == null) {
            return Result.fail("你没登录");
        }
        if (limoManage.getRId() == 1 || limoManage.getRId() == 2) {
            List<LimoOrder> list = orderService.list();
            return Result.success(200, "success", list);
        } else {
            return Result.fail("您的全限不足，不能查询订单");
        }
    }

    //查询订单详情,展示所有订单详情表
    @GetMapping("selectOrderDetail")
    @ApiOperation("查询订单详情,展示所有订单详情表")
    @ApiImplicitParam(name = "oid", value = "订单id", defaultValue = "67")
    public Result selectOrderDetail(Integer oid) throws Exception {
        QueryWrapper<LimoOrderDetail> limoOrderDetailQueryWrapper = new QueryWrapper<>();
        limoOrderDetailQueryWrapper.eq("o_id", oid);
        LimoOrderDetail orderDetail = orderDetailService.getOne(limoOrderDetailQueryWrapper);
        if (orderDetail == null) {
            return Result.fail(400, "没有该订单详情信息", null);
        }
        return Result.success(200, "success", orderDetail);
    }


    //根据用户id查询订单详情表
    @GetMapping("selectOrderDetailByUid")
    @ApiOperation("根据用户id查询订单详情表")
    @ApiImplicitParam(name = "uid", value = "用户id", defaultValue = "1")
    public Result selectOrderDetailByUid(Integer uid) throws Exception {
        List<OrderDetailParam> orderDetailParams = orderDetailService.selectOrderDetailByUid(uid);
        if (orderDetailParams.size() == 0 || orderDetailParams == null) {
            return Result.fail("该用户没有订单数据");
        } else {
            return Result.success(200, "success", orderDetailParams);
        }
    }


    //根据订单状态查询订单
    @GetMapping("selectOrderByStatus")
    @ApiOperation("根据订单状态查询订单")
    @ApiImplicitParam(name = "status", value = "订单状态", defaultValue = "0")
    public Result selectOrderByStatus(Integer status) throws Exception {
        List<OrderDetailParam> orderDetailParams = orderDetailService.selectOrderByStatus(status);
        if (orderDetailParams.size() == 0 || orderDetailParams == null) {
            return Result.fail("没有该状态的订单");
        } else {
            return Result.success(200, "success", orderDetailParams);
        }
    }

    //修改订单详情表状态
    @GetMapping("updateByStatus")
    @ApiOperation("修改订单详情表状态")
    @ApiImplicitParam(name = "oid", value = "订单id", defaultValue = "52")
    public Result updateByStatus(Integer oid) throws Exception {
        QueryWrapper<LimoOrder> limoOrderQueryWrapper = new QueryWrapper<>();
        limoOrderQueryWrapper.eq("o_id", oid);
        LimoOrder order = orderService.getOne(limoOrderQueryWrapper);
        if (order == null) {
            return Result.fail("没有该订单数据");
        }
        if (order.getOStatus() == 0) {
            return Result.fail("该订单还未支付，不能点击送达");
        }
        if (order.getOStatus() == 3) {
            return Result.fail("该订单已完成，无需再次点击");
        }
        if (order.getOStatus() == 4) {
            return Result.fail("该订单已失效,");
        }
        if (order.getOStatus() == 1 || order.getOStatus() == 2) {
            UpdateWrapper<LimoOrderDetail> limoOrderDetailUpdateWrapper = new UpdateWrapper<>();
            limoOrderDetailUpdateWrapper.set("or_status", 2).eq("o_id", oid);
            boolean update = orderDetailService.update(limoOrderDetailUpdateWrapper);
            return Result.success(200, "修改成功", update);
        } else {
            return Result.fail("无效");
        }
    }


    //营地活动的上架
    @GetMapping("campActivitiesDown")
    @ApiOperation("营地活动的上架")
    public Result campActivitiesDown()throws Exception{
        LimoManage limoManage = (LimoManage) SecurityUtils.getSubject().getPrincipal();
        if (limoManage == null) {
            return Result.fail("你没登录");
        }
        if (limoManage.getRId() == 1 || limoManage.getRId() == 2) {

        } else {
            return Result.fail("您的权限不足，不能商品下架");
        }
        return null;
    }



    //营地活动的上架
    @GetMapping("campActivitiesUp")
    @ApiOperation("营地活动的下架")
    public Result campActivitiesUp()throws Exception{
        LimoManage limoManage = (LimoManage) SecurityUtils.getSubject().getPrincipal();
        if (limoManage == null) {
            return Result.fail("你没登录");
        }
        if (limoManage.getRId() == 1 || limoManage.getRId() == 2) {

        } else {
            return Result.fail("您的权限不足，不能商品下架");
        }
        return null;
    }


}

