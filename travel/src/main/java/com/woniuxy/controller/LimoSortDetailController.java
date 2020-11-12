package com.woniuxy.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.exception.TravelExecption;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;

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
public class LimoSortDetailController {
    @Resource
    private LimoSortDetailService limoSortDetailService;

    //新增旅游文章(json格式)
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
    public JSONResult insertSort(@RequestBody String param)throws Exception{
        LimoSortDetail limoSortDetail = JSONObject.parseObject(param, LimoSortDetail.class);
        limoSortDetailService.save(limoSortDetail);
        return new JSONResult("200","success",null,null);
    }
    //查询旅游攻略（4个指南）
    @GetMapping("/selectAll")
    public JSONResult selectAll( )throws Exception{

        return new JSONResult("200","success",null,limoSortDetailService.selectAll());
    }

    //查询类别旅游指南文章的列表，
    @GetMapping("/selectByType")
    public JSONResult selectByType(TypeParam param)throws Exception{
        Object obj=limoSortDetailService.selectByType(param);
        return new JSONResult("200","success",null,obj);
    }
    //根据ID查询
    @GetMapping("/selectById")
    public JSONResult selectById(Integer id)throws Exception{
            if(id<=1){
               throw new TravelExecption("参数不正确");
            }
        return new JSONResult("200","success",null,limoSortDetailService.getById(id));
    }
}

