package com.woniuxy.controller;


import com.woniuxy.doman.LimoSecSpot;
import com.woniuxy.doman.LimoSort;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.woniuxy.service.LimoSortService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.BeanUtils;
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
public class LimoSecSpotController {
    @Resource
    private LimoSecSpotService limoSecSpotService;

    //新增周边景点
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @PostMapping
    public JSONResult insertSport(SortParam param) throws Exception{
        LimoSecSpot sort = new LimoSecSpot();
        BeanUtils.copyProperties(param,sort);
        limoSecSpotService.save(sort);
        return  new JSONResult("200","success",null,null);
    }
    //条件查询周边景点
    @GetMapping("/queryByParam")
    public JSONResult queryByParam(SortTypeParam param) throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.queryByParam(param));
    }
    //根据主键查询周边景点
    @GetMapping("/queryById")
    public JSONResult queryById(Integer id) throws Exception{


        return  new JSONResult("200","success",null,limoSecSpotService.getById(id));
    }

}

