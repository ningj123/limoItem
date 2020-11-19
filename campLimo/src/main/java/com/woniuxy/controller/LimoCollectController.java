package com.woniuxy.controller;

import com.woniuxy.domain.LimoCollect;
import com.woniuxy.param.LimoUser;
import com.woniuxy.service.CollectService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @ClassName LimoCollectController
 * @Author shadow
 * @Date 2020/11/9 14:53
 * @Description TODO
 **/
@CrossOrigin
@RestController
@RequestMapping("limo/collect")
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
    public JSONResult insertCollect(Integer cId,@RequestHeader("x-token") String token) throws Exception{
        /*ServletRequestAttributes ra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = ra.getRequest().getHeader("x-token");
        LimoUser user = LoginUtil.parseToken(token, LimoUser.class);*/
        System.out.println(token);
        Integer uId=1;
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
