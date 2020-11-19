package com.woniuxy.controller;


import com.woniuxy.param.PageParam;
import com.woniuxy.service.LimoCityService;
import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
 * @since 2020-11-09
 */
@RestController
@RequestMapping("/city")
@CrossOrigin
public class LimoCityController {
    @Resource
    private LimoCityService limoCityService;

    //查询所有城市的列表指南
    @GetMapping("/selectCItyList")
    public JSONResult selectCItyListByPage(PageParam param){

        return new JSONResult("200","success",null,limoCityService.selectCItyListByPage(param));
    }
    //根据城市查询列表指南
    @GetMapping("/selectByCityList")
    public JSONResult selectByCityList(PageParam param,String city){

        return new JSONResult("200","success",null,limoCityService.selectByCityList(param,city));
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
    //根据城市名字查询城市
    @GetMapping("/queryByCity")
    public JSONResult queryByCity(String city){

        return new JSONResult("200","success",null,limoCityService.queryByCity(city));
    }
}

