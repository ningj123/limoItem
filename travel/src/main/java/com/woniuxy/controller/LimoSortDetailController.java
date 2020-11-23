package com.woniuxy.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.exception.TravelExecption;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.LSDParam1;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import io.swagger.annotations.*;
import org.redisson.Redisson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-07
 */
@RestController
@RequestMapping("/limoSortDetail")
@Api(tags="旅游指南")
@CrossOrigin
public class LimoSortDetailController {
    @Resource
    private LimoSortDetailService limoSortDetailService;
    @Autowired
    private RedisTemplate<String,String>  redisTemplate;

    //新增旅游文章(json格式)
    @ApiOperation(value = "新增旅游文章(json格式)")
    @PostMapping
    @ApiImplicitParams({

            @ApiImplicitParam(name = "soDName",value = "标题"),
            @ApiImplicitParam(name = "soDDes",value = "描述") ,
            @ApiImplicitParam(name = "soDName",value = "标题"),
            @ApiImplicitParam(name = "soDImages",value = "图片路径"),
            @ApiImplicitParam(name = "soDType",value = "类别(0 热门 1 营地 2 美食 3 景区)") ,
            @ApiImplicitParam(name = "soDDes",value = "描述") ,
            @ApiImplicitParam(name = "soDCity",value = "城市"),
            @ApiImplicitParam(name = "soId",value = "关联城市的id"),
            @ApiImplicitParam(name = "soDKeyword",value = "关键字"),
            @ApiImplicitParam(name = "soDStatus",value = "状态(0 开放 1 不开放)"),

    })
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public JSONResult insertTravelSort(@RequestBody LSDParam1 param, @RequestHeader("x-token")String token) throws Exception{
        Map<String, Object> map = LoginUtil.parseToken(token);

        limoSortDetailService.saveDetail(param,map);
        return new JSONResult("200","success",null,null);
    }
    //新增旅游文章(text格式)
   // @PostMapping("/sort")
    //@ApiOperation(value = "新增旅游文章(text格式)")
    public JSONResult insertSort(String param)throws Exception{
        LimoSortDetail limoSortDetail = JSONObject.parseObject(param, LimoSortDetail.class);
        limoSortDetailService.save(limoSortDetail);
        return new JSONResult("200","success",null,null);
    }
    //查询旅游攻略（4个指南）
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询旅游攻略（4个指南）")
    public JSONResult selectAll( )throws Exception{

        return new JSONResult("200","success",null,limoSortDetailService.selectAll());
    }

    //根据类别查询旅游指南文章的列表，
    @GetMapping("/selectByType")
    @ApiOperation(value = "根据类别查询旅游指南文章的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "类别"),
            @ApiImplicitParam(name = "keyWord",value = "关键字"),
    })
    public JSONResult selectByType(TypeParam param)throws Exception{
        Object obj=limoSortDetailService.selectByType(param);
        return new JSONResult("200","success",null,obj);
    }
    //根据ID查询
    @GetMapping("/selectById")
    @ApiOperation(value = "根据ID查询旅游指南文章")
    @ApiParam(name = "id",value = "主键")
    public JSONResult selectById(Integer id)throws Exception{
            if(id<0){
               throw new TravelExecption("参数不正确");
    }




        return new JSONResult("200","success",null,limoSortDetailService.selectById(id));
    }
    //查询所有
    @GetMapping("/queryAllByDetail")
    @ApiOperation(value = "查询所有旅游文章")
    public JSONResult queryAll(){
        List lits=limoSortDetailService.queryAll();

        return  new JSONResult("200","success",lits,null);
    }
    //修改旅游文章(json格式)
    @ApiOperation(value = "修改旅游文章(json格式)")
    @PostMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "soDId",value = "id"),
            @ApiImplicitParam(name = "soDName",value = "标题"),
            @ApiImplicitParam(name = "soDDes",value = "描述") ,
            @ApiImplicitParam(name = "soDName",value = "标题"),
            @ApiImplicitParam(name = "soDImages",value = "图片路径"),
            @ApiImplicitParam(name = "soDType",value = "类别(0 热门 1 营地 2 美食 3 景区)") ,
            @ApiImplicitParam(name = "soDDes",value = "描述") ,
            @ApiImplicitParam(name = "soDCity",value = "城市"),
            @ApiImplicitParam(name = "soId",value = "关联城市的id"),
            @ApiImplicitParam(name = "soDKeyword",value = "关键字"),
            @ApiImplicitParam(name = "soDStatus",value = "状态(0 开放 1 不开放)"),

    })
    public JSONResult updateTravelSort(@RequestBody LSDParam param) throws Exception{

        limoSortDetailService.updateTravelSort(param);
        return new JSONResult("200","success",null,null);
    }
}

