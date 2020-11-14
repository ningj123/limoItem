package com.woniuxy.controller;


import com.alibaba.fastjson.JSONObject;
import com.woniuxy.domain.LimoSortDetail;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/limoSortDetail")
public class LimoSortDetailController {
    @Resource
    private LimoSortDetailService limoSortDetailService;

    //修改旅游文章(json格式)
    @ApiOperation(value = "修改旅游文章(json格式)")
    @PostMapping
    public JSONResult insertTravelSort(@RequestBody LSDParam param) throws Exception{



        limoSortDetailService.updateTravelSort(param);
        return new JSONResult("200","success",null,null);
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
            throw new Exception("参数不正确");
        }

        return new JSONResult("200","success",null,limoSortDetailService.getById(id));
    }
    //查询所有
    @GetMapping("/queryAllByDetail")
    @ApiOperation(value = "查询所有")
    public JSONResult queryAll() throws Exception {
        List lits=limoSortDetailService.queryAll();

        return  new JSONResult("200","success",lits,null);
    }
    //修改旅游文章(json格式)
    @ApiOperation(value = "修改旅游文章(json格式)")
    @PostMapping
    public JSONResult updateTravelSort(@RequestBody LSDParam param) throws Exception{

        limoSortDetailService.updateTravelSort(param);
        return new JSONResult("200","success",null,null);
    }
}

