package com.woniuxy.controller;


import com.woniuxy.doman.LimoSecSpot;
import com.woniuxy.doman.LimoSort;
import com.woniuxy.dto.LimoSecSpotDto;
import com.woniuxy.exception.TravelExecption;
import com.woniuxy.param.*;
import com.woniuxy.service.LimoSecSpotService;
import com.woniuxy.doman.LimoSecSpot;
import com.woniuxy.doman.LimoSort;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.woniuxy.service.LimoSortService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;

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
@Api(tags="周边景点")
@CrossOrigin
public class LimoSecSpotController {
    @Resource
    private LimoSecSpotService limoSecSpotService;

    //新增周边景点
    //@PostMapping
    //@ApiOperation(value = "新增周边景点")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "secSportName",value = "景区的名字"),
    //        @ApiImplicitParam(name = "secSportAddress",value = "景区的地址") ,
    //        @ApiImplicitParam(name = "secSportCity",value = "城市"),
    //        @ApiImplicitParam(name = "cId",value = "营地ID"),
    //        @ApiImplicitParam(name = "cName",value = "营地的名字") ,
    //        @ApiImplicitParam(name = "secSportOpentime",value = "景区的营业时间") ,
    //        @ApiImplicitParam(name = "secSportServer",value = "景区的特色服务"),
    //        @ApiImplicitParam(name = "secSportImgurl",value = "图片的路径"),
    //        @ApiImplicitParam(name = "secSportPrice",value = "景区的价格"),
    //        @ApiImplicitParam(name = "precision",value = "经度"),
    //        @ApiImplicitParam(name = "dimension",value = "纬度"),
    //
    //})
    //public JSONResult insertSport(SortParam1 param) throws Exception{
    //
    //
    //    limoSecSpotService.insertSport(param);
    //
    //
    //    return  new JSONResult("200","success",null,null);
    //}
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
    @ApiParam(name = "id",value = "主键")
    public JSONResult queryById(Integer id) throws Exception{
        if(id<=0){
            throw new TravelExecption("参数异常");
        }
        //LimoSecSpotDto limoSecSpotDto = limoSecSpotService.queryById(id);

        return  new JSONResult("200","success",null,limoSecSpotService.getById(id));
    }
    @GetMapping("/queryBySec")
    @ApiOperation(value = "初始化所有的经纬度")
    public JSONResult queryBySec() throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.redisGeoAdd());
    }
    @GetMapping("/queryBypa")
    @ApiOperation(value = "通过地方的经纬度查询周边")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "precision",value = "经度"),
            @ApiImplicitParam(name = "dimension",value = "纬度"),
            @ApiImplicitParam(name = "distance",value = "范围")

    })
    public JSONResult queryBypa(PointParam param) throws Exception{


        return  new JSONResult("200","success",limoSecSpotService.geoNearByPlace(param),null);
    }

    //修改周边景点
    //@PostMapping("/updateSport")
    //@ApiOperation(value = "修改周边景点")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "soDId",value = "主键"),
    //        @ApiImplicitParam(name = "secSportName",value = "景区的名字"),
    //        @ApiImplicitParam(name = "secSportAddress",value = "景区的地址") ,
    //        @ApiImplicitParam(name = "secSportCity",value = "城市"),
    //        @ApiImplicitParam(name = "cId",value = "营地ID"),
    //        @ApiImplicitParam(name = "cName",value = "营地的名字") ,
    //        @ApiImplicitParam(name = "secSportOpentime",value = "景区的营业时间") ,
    //        @ApiImplicitParam(name = "secSportServer",value = "景区的特色服务"),
    //        @ApiImplicitParam(name = "secSportImgurl",value = "图片的路径"),
    //        @ApiImplicitParam(name = "secSportPrice",value = "景区的价格"),
    //        @ApiImplicitParam(name = "precision",value = "经度"),
    //        @ApiImplicitParam(name = "dimension",value = "纬度"),
    //
    //})
    //public JSONResult updateSport(SortParam param) throws Exception{
    //
    //
    //    limoSecSpotService.updateSport(param);
    //
    //
    //    return  new JSONResult("200","success",null,null);
    //}
}

