package com.woniuxy.controller;


import com.woniuxy.service.LimoSortService;
import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *不需要，重复
 * @author shadow
 * @since 2020-11-12
 */
//@Controller
//@RequestMapping("/limoSort")
public class LimoSortController {
    @Resource
    private LimoSortService limoSortService;

    /**
     * @Author zhuyuli
     * @Description 查询所有城市
     * @Date 2020/11/10 14:08
     * @Param []
     * @return com.woniuxy.util.JSONResult
     **/
    @GetMapping("/queryAll")
    public JSONResult queryAll(){

        return new JSONResult("200","success",limoSortService.list(),null);
    }
    /**
     * @Author zhuyuli
     * @Description 根据主键查询城市
     * @Date 2020/11/10 14:11
     * @Param [id]
     * @return com.woniuxy.util.JSONResult
     **/
    @GetMapping("/queryId")
    public JSONResult queryId(Integer id)throws Exception{
        if (id < 1) {
            throw new Exception("参数异常");
        }
        return new JSONResult("200","success",null,limoSortService.getById(id));
    }
}

