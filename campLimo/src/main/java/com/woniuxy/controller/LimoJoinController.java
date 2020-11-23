package com.woniuxy.controller;

import com.woniuxy.param.JoinParam;
import com.woniuxy.service.JoinService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LimoJoinController
 * @Author shadow
 * @Date 2020/11/10 9:50
 * @Description TODO
 **/
@RestController
@RequestMapping("limo/join")
@Api(tags = "营地或房车加盟")
public class LimoJoinController {
    @Autowired
    private JoinService joinService;
    /**
     * 新增房车或营地加盟
     * @param joinParam
     * @return
     * @throws Exception
     */
    @PostMapping("insertLimoJoin")
    @ApiOperation(value = "营地或房车加盟")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jName", value = "房车或营地加盟人的姓名", dataType = "String"),
            @ApiImplicitParam(name = "jPhone", value = "房车或营地加盟人的电话", dataType = "String"),
            @ApiImplicitParam(name = "jSerail", value = "房车加盟人的房车编号", dataType = "String"),
            @ApiImplicitParam(name = "jLimoAddress", value = "房车加盟人的房车所在地", dataType = "String"),
            @ApiImplicitParam(name = "jLimoType", value = "房车加盟人的房车车型", dataType = "String"),
            @ApiImplicitParam(name = "cId", value = "房车加盟人所加盟的营地", dataType = "Integer"),
            @ApiImplicitParam(name = "jCardImages", value = "房车加盟人的身份证图片地址", dataType = "String"),
            @ApiImplicitParam(name = "jLimoImages", value = "房车加盟人的房车图片地址", dataType = "String"),
            @ApiImplicitParam(name = "jStartTime", value = "房车加盟人的房车投放开始时间", dataType = "String"),
            @ApiImplicitParam(name = "jEndTime", value = "房车加盟人的房车投放结束时间", dataType = "String"),
            @ApiImplicitParam(name = "jRemark", value = "加盟备注", dataType = "String"),
            @ApiImplicitParam(name = "jEmail", value = "营地加盟的邮箱", dataType = "String"),
            @ApiImplicitParam(name = "jCampName", value = "营地加盟的营地名称", dataType = "String"),
            @ApiImplicitParam(name = "jType", value = "加盟类型(1房车加盟2营地加盟)", dataType = "String"),
            @ApiImplicitParam(name = "jStatus", value = "加盟后状态", dataType = "Integer"),
            @ApiImplicitParam(name = "city", value = "城市名", dataType = "String")
    })
    public JSONResult insertLimoJoin(JoinParam joinParam)throws Exception{
        if(joinParam.getcId()==null){
            joinParam.setjType(2);
        }else {
            joinParam.setjType(1);
        }
        joinService.insertLimoJoin(joinParam);
        return new JSONResult("200","success",null,null);
    }
}
