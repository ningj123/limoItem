package com.woniuxy.controller;

import com.woniuxy.domain.LimoCollect;
import com.woniuxy.param.LimoUser;
import com.woniuxy.service.CollectService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

/**
 * @ClassName LimoCollectController
 * @Author shadow
 * @Date 2020/11/9 14:53
 * @Description TODO
 **/
@CrossOrigin
@RestController
@RequestMapping("limo/collect")
@Api(tags = "营地收藏")
public class LimoCollectController {
    @Autowired
    private CollectService collectService;

    /**
     * 营地收藏
     * @param cId
     * @return
     * @throws Exception
     */
    @PostMapping("insertCollect")
    @ApiOperation(value = "营地收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId", value = "营地id", dataType = "Integer",defaultValue = "1"),
//            @ApiImplicitParam(name = "token", value = "用户登录后的token", dataType = "String")
    })
    public JSONResult insertCollect(Integer cId,@RequestHeader("x-token") String token) throws Exception{
        /*ServletRequestAttributes ra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = ra.getRequest().getHeader("x-token");*/
        Map<String, Object> map = LoginUtil.parseToken(token);
        Integer uId=(Integer) map.get("uId");
        LimoCollect limoCollect = collectService.selectCollect(cId,uId);
        if(limoCollect==null){
            collectService.insertCollect(cId,uId);
            return new JSONResult("200","新增收藏成功",null,null);
        }else{
            collectService.deleteCollect(limoCollect.getCoId());
            return new JSONResult("200","取消收藏成功",null,null);
        }
    }
}
