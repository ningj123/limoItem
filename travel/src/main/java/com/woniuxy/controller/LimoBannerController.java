package com.woniuxy.controller;


import com.woniuxy.param.BanParam;
import com.woniuxy.service.LimoBannerService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.naming.Name;

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
@Api(tags="广告管理")
@CrossOrigin
public class LimoBannerController {
    @Autowired
    private LimoBannerService limoBannerService;

    //根据类别分页查询广告列表
    @GetMapping("/selectList")
    @ApiOperation(value = "根据类别分页查询广告列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize",value = "显示条数",defaultValue = "2"),
            @ApiImplicitParam(name = "pageNum",value = "第几页",defaultValue = "1"),
            @ApiImplicitParam(name = "type",value = "类型",defaultValue = "0") ,
    })
    public JSONResult queryBannerList(Integer pageSize,Integer pageNum,Integer type)throws Exception{
        Object obj=limoBannerService.queryBannerList(pageSize,pageNum,type);

        return new JSONResult("200","success",null,obj);
    }
    //根据ID主键查询广告
    @GetMapping("/selectById")
    @ApiOperation(value = "根据ID主键查询广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",defaultValue = "1"),
    })
    public JSONResult queryBannerById(Integer id)throws Exception{

        return new JSONResult("200","success",null,limoBannerService.getById(id));
    }
    //根据类别查询
    @GetMapping("/selectByType")
    @ApiOperation(value = "根据类别查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "类别",defaultValue = "0"),
    })
    public JSONResult queryBannerByType(Integer type)throws Exception{

        return new JSONResult("200","success",limoBannerService.queryBannerByType(type),null);
    }
    //更新广告
    //@PostMapping("/update")
    //@ApiOperation(value = "更新广告")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "id",value = "id",defaultValue = "1"),
    //        @ApiImplicitParam(name = "imgUrl",value = "图片路径",defaultValue = "sadwqfsvf.jpg"),
    //        @ApiImplicitParam(name = "lianId",value = "关联的id",defaultValue = "1") ,
    //})
    //public JSONResult updateBannerById(@RequestBody BanParam param)throws Exception{
    //    limoBannerService.updateBannerById(param);
    //    return new JSONResult("200","success",null,null);
    //}
}

