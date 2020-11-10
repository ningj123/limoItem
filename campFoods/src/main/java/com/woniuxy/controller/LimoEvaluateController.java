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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("/selectEvaluate")
    public JSONResult selectEvaluate(EvaluateParam evaluateParam)throws Exception{
        //获取评价信息
        Page<LimoEvaluate> page = limoEvaluateService.selectEvaluate(evaluateParam);
        //查询评价的用户信息
        List<LimoEvaluate> records = page.getRecords();
        ArrayList<EvaluateDto> list = new ArrayList<>();
        for (LimoEvaluate evaluate:records){
            LimoUser user = limoUserService.getById(evaluate.getUId());
            EvaluateDto evaluateDto = new EvaluateDto();
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(evaluate,evaluateDto);
            BeanUtils.copyProperties(user,userDto);
            evaluateDto.setUserDto(userDto);
            list.add(evaluateDto);
        }
        return new JSONResult("200","success",list,page);
    }

}

