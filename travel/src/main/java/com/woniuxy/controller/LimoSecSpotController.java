package com.woniuxy.controller;


import com.woniuxy.doman.LimoSecSpot;
import com.woniuxy.doman.LimoSort;
import com.woniuxy.dto.LimoSecSpotDto;
import com.woniuxy.param.PointParam;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.woniuxy.service.LimoSortService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api("周边景点")
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
        LimoSecSpotDto limoSecSpotDto = limoSecSpotService.queryById(id);

        return  new JSONResult("200","success",null,limoSecSpotDto);
    }
    @GetMapping("/queryBySec")
    @ApiOperation(value = "初始化所有的经纬度")
    public JSONResult queryBySec() throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.redisGeoAdd());
    }
    @GetMapping("/queryBypa")
    @ApiOperation(value = "通过地方的经纬度查询周边")
    public JSONResult queryBypa(PointParam param) throws Exception{


        return  new JSONResult("200","success",limoSecSpotService.geoNearByPlace(param),null);
    }
}

