package com.woniuxy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoEvaluate;
import com.woniuxy.domain.LimoUser;
import com.woniuxy.dto.EvaluateDto;
import com.woniuxy.dto.UserDto;
import com.woniuxy.param.EvaluateParam;
import com.woniuxy.service.LimoEvaluateService;
import com.woniuxy.service.LimoUserService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/evaluate")
@CrossOrigin
@Api(value = "评论模块")
public class LimoEvaluateController {
    @Autowired
    private LimoEvaluateService limoEvaluateService;
    //用户业务层对象
    @Autowired
    private LimoUserService limoUserService;
    /**
     * 查询评价信息
     * @return
     * @throws Exception
     */
    @GetMapping("/selectEvaluate")
    @ApiOperation(value = "根据用户编号或商品编号查询相应的评价信息")
    public JSONResult selectEvaluate(EvaluateParam evaluateParam)throws Exception{
        return new JSONResult("200","success",null,limoEvaluateService.selectEvaluate(evaluateParam));
    }

    /**
     * 新增评价
     * @param evaluateParam
     * @return
     * @throws Exception
     */
    @PostMapping("/insertEvaluate")
    @ApiOperation(value = "新增评价信息")
    public JSONResult insertEvaluate(@RequestHeader("x-token")String token, EvaluateParam evaluateParam)throws Exception{
        Map<String, Object> map = LoginUtil.parseToken(token);
        evaluateParam.setUId((Integer) map.get("uId"));
        limoEvaluateService.insertEvaluate(evaluateParam);
        return new JSONResult("200","success",null,null);
    }

}

