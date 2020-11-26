package com.woniuxy.controller;


import com.woniuxy.service.LimoAppointService;
import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/limoAppoint")
public class LimoAppointController {
    @Resource
    private LimoAppointService limoAppointService;

    public JSONResult queryH(String startTime,String endtime ) throws Exception {
        List list=  limoAppointService.qurty(startTime,endtime);
        return new JSONResult("200","success",null,null);
    }

}

