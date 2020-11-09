package com.woniuxy.controller;


import com.woniuxy.param.BanParam;
import com.woniuxy.service.LimoBannerService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  广告管理前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
@RestController
@RequestMapping("/banner")
public class LimoBannerController {
    @Autowired
    private LimoBannerService limoBannerService;

    //根据类别分页查询广告列表
    @GetMapping("/selectList")
    public JSONResult queryBannerList(Integer pageSize,Integer pageNum,Integer type)throws Exception{
        Object obj=limoBannerService.queryBannerList(pageSize,pageNum,type);

        return new JSONResult("200","success",null,obj);
    }
    //根据ID主键查询广告
    @GetMapping("/selectById")
    public JSONResult queryBannerById(Integer id)throws Exception{

        return new JSONResult("200","success",null,limoBannerService.getById(id));
    }
    //根据ID主键查询广告
    @GetMapping("/selectByType")
    public JSONResult queryBannerByType(Integer type)throws Exception{

        return new JSONResult("200","success",limoBannerService.queryBannerByType(type),null);
    }
    //更新广告
    @PostMapping("/update")
    public JSONResult updateBannerById(@RequestBody BanParam param)throws Exception{
        limoBannerService.updateBannerById(param);
        return new JSONResult("200","success",null,null);
    }
}

