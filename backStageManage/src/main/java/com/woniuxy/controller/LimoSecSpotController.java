package com.woniuxy.controller;


import com.woniuxy.dto.LimoSecSpotDto;
import com.woniuxy.param.PointParam;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortParam1;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
@Api(tags="景区管理")
public class LimoSecSpotController {
    @Resource
    private LimoSecSpotService limoSecSpotService;


    //新增周边景点
    @PostMapping
    @ApiOperation(value = "新增周边景点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "secSportName",value = "景区的名字"),
            @ApiImplicitParam(name = "secSportAddress",value = "景区的地址") ,
            @ApiImplicitParam(name = "secSportCity",value = "城市"),
            @ApiImplicitParam(name = "cId",value = "营地ID"),
            @ApiImplicitParam(name = "cName",value = "营地的名字") ,
            @ApiImplicitParam(name = "secSportOpentime",value = "景区的营业时间") ,
            @ApiImplicitParam(name = "secSportServer",value = "景区的特色服务"),
            @ApiImplicitParam(name = "secSportImgurl",value = "图片的路径"),
            @ApiImplicitParam(name = "secSportPrice",value = "景区的价格"),
            @ApiImplicitParam(name = "precision",value = "经度"),
            @ApiImplicitParam(name = "dimension",value = "纬度"),

    })
    public JSONResult insertSport(SortParam1 param1) throws Exception{
        SortParam param=new SortParam();
        BeanUtils.copyProperties(param1,param);
        limoSecSpotService.insertSport(param);


        return  new JSONResult("200","success",null,null);
    }
    //条件查询周边景点
    @GetMapping("/queryByParam")
    @ApiOperation(value = "条件查询周边景点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",value = "城市"),
            @ApiImplicitParam(name = "cId",value = "营地ID"),
            @ApiImplicitParam(name = "secname",value = "景点id")

    })
    public JSONResult queryByParam(SortTypeParam param) throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.queryByParam(param));
    }
    //根据主键查询周边景点
    @GetMapping("/queryById")
    @ApiOperation(value = "根据主键查询周边景点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键"),


    })
    public JSONResult queryById(Integer id) throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.getById(id));
    }
    //新增周边景点
    @PostMapping("/updateSport")
    @ApiOperation(value = "更新周边景点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "soDId",value = "主键"),
            @ApiImplicitParam(name = "secSportName",value = "景区的名字"),
            @ApiImplicitParam(name = "secSportAddress",value = "景区的地址") ,
            @ApiImplicitParam(name = "secSportCity",value = "城市"),
            @ApiImplicitParam(name = "cId",value = "营地ID"),
            @ApiImplicitParam(name = "cName",value = "营地的名字") ,
            @ApiImplicitParam(name = "secSportOpentime",value = "景区的营业时间") ,
            @ApiImplicitParam(name = "secSportServer",value = "景区的特色服务"),
            @ApiImplicitParam(name = "secSportImgurl",value = "图片的路径"),
            @ApiImplicitParam(name = "secSportPrice",value = "景区的价格"),
            @ApiImplicitParam(name = "precision",value = "经度"),
            @ApiImplicitParam(name = "dimension",value = "纬度"),

    })
    public JSONResult updateSport(SortParam param) throws Exception{


        limoSecSpotService.updateSport(param);


        return  new JSONResult("200","success",null,null);
    }
}

