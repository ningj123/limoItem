package com.woniuxy.controller;


import com.woniuxy.service.LimoSortService;
import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  周边景点前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/limoSecSpot")
public class LimoSecSpotController {
    @Resource
    private LimoSortService limoSortService;
    @PostMapping
    public JSONResult insertSport(){
        return  new JSONResult("200","success",null,null);
    }
}

