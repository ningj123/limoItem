package com.woniuxy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.woniuxy.doman.LimoAppoint;
import com.woniuxy.doman.LimoHotel;
import com.woniuxy.param.AppParam;
import com.woniuxy.param.DetailParam;
import com.woniuxy.param.SleepParam;
import com.woniuxy.service.LimoHotelService;
import com.woniuxy.util.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/limoHotel")
public class LimoHotelController {
    @Resource
    private LimoHotelService limoHotelService;
    /**
     * @Author zhuyuli
     * @Description //查询预约信息
     * @Date 2020/11/25 14:36
     * @Param []
     * @return com.woniuxy.util.JSONResult
     **/
    @GetMapping("/query")
    public JSONResult queryHotel(DetailParam detail) throws Exception {

        return new JSONResult("200","success",limoHotelService.queryHotel(detail),null);
    }
    //查询使用情况
    @GetMapping("/queryWork")
    public JSONResult queryWork(Integer hid,Integer status) throws Exception {

        return new JSONResult("200","success",limoHotelService.queryWork(hid,status),null);
    }
    /**
     * @Author zhuyuli
     * @Description //办理入住
     * @Date 2020/11/25 14:59
     * @Param [detail]
     * @return com.woniuxy.util.JSONResult
     **/
    @PostMapping("/insertHotel")
    public JSONResult insertHotel(SleepParam sleepParam)throws Exception{
        limoHotelService.insertHotel(sleepParam);
        return new JSONResult("200","success",null,null);
    }
    @PostMapping("/insertHoteldetail")
    public JSONResult insertHoteldetail(AppParam param)throws Exception{
        limoHotelService.insertHoteldetail(param);

        return new JSONResult("200","success",null,null);
    }
    //申请退房
    @PostMapping("/outHotel")
    public JSONResult outHotel(Integer apid,Integer hid)throws Exception{
        limoHotelService.outHotel(apid,hid);

        return new JSONResult("200","success",null,null);
    }
}

