package com.woniuxy.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.param.LSDParam;
import com.woniuxy.service.LimoSortDetailService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
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

    //新增旅游文章
    @PostMapping
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public JSONResult insertTravelSort(@RequestBody LSDParam param){

        LimoSortDetail limo = new LimoSortDetail();
        BeanUtils.copyProperties(param, limo);
        System.out.println(param);
        limoSortDetailService.save(limo);
        return new JSONResult("200","success",null,null);
    }
    //查询旅游攻略（4个类别）

}

