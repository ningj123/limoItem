package com.woniuxy.controller;


import com.woniuxy.param.LimoCityParam;
import com.woniuxy.param.PageParam;
import com.woniuxy.service.LimoCityService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.Api;
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
 * @author shadow
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/limoCity")
@Api(tags = "城市管理")
public class LimoCityController {
    @Resource
    private LimoCityService limoCityService;

    //查询所有城市的列表指南
    @GetMapping("/selectCItyList")
    public JSONResult selectCItyListByPage(PageParam param) throws Exception {

        return new JSONResult("200","success",null,limoCityService.selectCItyListByPage(param));
    }
    //查询所有城市
    @GetMapping("/queryAll")
    public JSONResult queryAll(){

        return new JSONResult("200","success",limoCityService.list(),null);
    }
    //根据主键查询城市
    @GetMapping("/queryById")
    public JSONResult queryById(Integer id){

        return new JSONResult("200","success",null,limoCityService.getById(id));
    }
    //新增城市
    @PostMapping("/insertCity")
    public JSONResult insertCity(LimoCityParam param){
        limoCityService.insertCity(param);
        return new JSONResult("200","success",null,null);
    }
}

