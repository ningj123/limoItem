package com.woniuxy.controller;

import com.woniuxy.param.LimoUser;
import com.woniuxy.service.CollectService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @ClassName LimoCollectController
 * @Author shadow
 * @Date 2020/11/9 14:53
 * @Description TODO
 **/
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
    public JSONResult insertCollect(Integer cId) throws Exception{
        /*ServletRequestAttributes ra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = ra.getRequest().getHeader("shadow-token");
        LimoUser user = LoginUtil.parseToken(token, LimoUser.class);*/
        Integer uId=1;
        collectService.insertCollect(cId,uId);
        return new JSONResult("200","success",null,null);
    }
}
