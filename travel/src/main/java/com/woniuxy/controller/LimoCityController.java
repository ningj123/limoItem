package com.woniuxy.controller;


import com.woniuxy.param.PageParam;
import com.woniuxy.service.LimoCityService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.*;
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
@Api(tags="景区城市服务")
public class LimoCityController {
    @Resource
    private LimoCityService limoCityService;

    //查询所有城市的列表指南
    @GetMapping("/selectCItyList")
    @ApiOperation(value = "分页查询城市信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize",value = "显示条数",defaultValue = "2"),
            @ApiImplicitParam(name = "pageSize",value = "显示第几页",defaultValue = "1")
    })
    public JSONResult selectCItyListByPage(PageParam param){

        return new JSONResult("200","success",null,limoCityService.selectCItyListByPage(param));
    }
    //根据城市查询列表指南
    @GetMapping("/selectByCityList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize",value = "显示条数",defaultValue = "2"),
            @ApiImplicitParam(name = "pageSize",value = "显示第几页",defaultValue = "1"),
            @ApiImplicitParam(name = "city",value = "城市",defaultValue = "重庆")
    })
    @ApiOperation(value = "条件分页查询城市信息")
    public JSONResult selectByCityList(PageParam param,String city){

        return new JSONResult("200","success",null,limoCityService.selectByCityList(param,city));
    }
    //查询所有城市
    @GetMapping("/queryAll")
    @ApiOperation(value = "查询所有城市信息")
    public JSONResult queryAll(){

        return new JSONResult("200","success",limoCityService.list(),null);
    }
    //根据主键查询城市
    @GetMapping("/queryById")
    @ApiOperation(value = "根据主键查询城市信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "城市主键"),
    })
    public JSONResult queryById(Integer id){

        return new JSONResult("200","success",null,limoCityService.getById(id));
    }
    //根据城市名字查询城市
    @GetMapping("/queryByCity")
    @ApiOperation(value = "根据城市查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",value = "城市"),
    })
    public JSONResult queryByCity(String city){

        return new JSONResult("200","success",null,limoCityService.queryByCity(city));
    }
}

