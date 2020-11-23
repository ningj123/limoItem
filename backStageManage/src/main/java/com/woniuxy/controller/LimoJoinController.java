package com.woniuxy.controller;


import com.woniuxy.param.JoinParam;
import com.woniuxy.service.LimoJoinService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shadow
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/join")
@Api("加盟管理")
public class LimoJoinController {
    @Autowired
    private LimoJoinService limoJoinService;
    /**
     * 查询加盟信息
     * @param
     * @return
     * @throws Exception
     */
    @GetMapping("/selectJoin")
    @ApiOperation(value = "查询加盟信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页码"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数")
    })
    public JSONResult selectJion(Integer pageNum,Integer pageSize)throws Exception{
        return new JSONResult("200","success",null,limoJoinService.selectJion(pageNum,pageSize));
    }
    /**
     * 查询加盟详细信息
     * @param jId
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectJoinById")
    @ApiOperation(value = "查询加盟详情")
    @ApiImplicitParam(name = "jId",value = "加盟编号")
    public JSONResult selectJoinById(Integer jId)throws Exception{
        return new JSONResult("200","success",null,limoJoinService.getById(jId));
    }

    /**
     * 根据加盟编号修改加盟状态
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/apply")
    @ApiOperation(value = "修改加盟状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jId",value = "加盟编号"),
            @ApiImplicitParam(name = "jStatus",value = "加盟状态")
    })

    public JSONResult updateStatus(Integer jId,Integer jStatus)throws Exception{
        limoJoinService.updateStatus(jId,jStatus);
        return new JSONResult("200","success",null,null);
    }

}

