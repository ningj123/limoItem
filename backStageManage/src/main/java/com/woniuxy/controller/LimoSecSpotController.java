package com.woniuxy.controller;


import com.woniuxy.dto.LimoSecSpotDto;
import com.woniuxy.param.PointParam;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/limoSecSpot")
public class LimoSecSpotController {
    @Resource
    private LimoSecSpotService limoSecSpotService;

    //新增周边景点
    @PostMapping
    @ApiOperation(value = "新增周边景点")
    public JSONResult insertSport(SortParam param) throws Exception{


        limoSecSpotService.insertSport(param);


        return  new JSONResult("200","success",null,null);
    }
    //条件查询周边景点
    @GetMapping("/queryByParam")
    @ApiOperation(value = "条件查询周边景点")
    public JSONResult queryByParam(SortTypeParam param) throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.queryByParam(param));
    }
    //根据主键查询周边景点
    @GetMapping("/queryById")
    @ApiOperation(value = "根据主键查询周边景点")
    public JSONResult queryById(Integer id) throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.getById(id));
    }
    //新增周边景点
    @PostMapping("update")
    @ApiOperation(value = "更新周边景点")
    public JSONResult updateSport(SortParam param) throws Exception{


        limoSecSpotService.updateSport(param);


        return  new JSONResult("200","success",null,null);
    }
}

