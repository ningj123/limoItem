package com.woniuxy.controller;


import com.woniuxy.service.LimoOrderDetailService;
import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
@RestController
@RequestMapping("/limoOrderDetail")
public class LimoOrderDetailController {
    @Resource
    private LimoOrderDetailService limoOrderDetailService;
    /**
     * 查询某个房车的订单信息
     * @param pId
     * @return
     * @throws Exception
     */
    @GetMapping("selectOrderDetailByPid")
    public JSONResult selectOrderDetailByPid(Integer pId) throws Exception{
        return new JSONResult("200","success",limoOrderDetailService.selectOrderDetailByPid(pId),null);
    }
}

