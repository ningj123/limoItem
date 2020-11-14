package com.woniuxy.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.exception.TravelExecption;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("旅游指南")
public class LimoSortDetailController {
    @Resource
    private LimoSortDetailService limoSortDetailService;
    @Autowired
    private RedisTemplate<String,String>  redisTemplate;

    //新增旅游文章(json格式)
    @ApiOperation(value = "新增旅游文章(json格式)")
    @PostMapping
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public JSONResult insertTravelSort(@RequestBody LSDParam param) throws Exception{

        LimoSortDetail limo = new LimoSortDetail();
        BeanUtils.copyProperties(param, limo);
        System.out.println(param);
        limoSortDetailService.save(limo);
        return new JSONResult("200","success",null,null);
    }
    //新增旅游文章(text格式)
    @PostMapping("/sort")
    @ApiOperation(value = "新增旅游文章(text格式)")
    public JSONResult insertSort(@RequestBody String param)throws Exception{
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
    public JSONResult selectByType(TypeParam param)throws Exception{
        Object obj=limoSortDetailService.selectByType(param);
        return new JSONResult("200","success",null,obj);
    }
    //根据ID查询
    @GetMapping("/selectById")
    @ApiOperation(value = "根据ID查询")
    public JSONResult selectById(Integer id)throws Exception{
            if(id<0){
               throw new TravelExecption("参数不正确");
            }
        LimoSortDetail detail = limoSortDetailService.selectById(id);



        return new JSONResult("200","success",null,detail);
    }
    //查询所有
    @GetMapping("/queryAllByDetail")
    @ApiOperation(value = "查询所有")
    public JSONResult queryAll(){
        List lits=limoSortDetailService.queryAll();

        return  new JSONResult("200","success",lits,null);
    }
    //修改旅游文章(json格式)
    @ApiOperation(value = "修改旅游文章(json格式)")
    @PostMapping("/update")
    public JSONResult updateTravelSort(@RequestBody LSDParam param) throws Exception{



        limoSortDetailService.updateTravelSort(param);
        return new JSONResult("200","success",null,null);
    }
}

