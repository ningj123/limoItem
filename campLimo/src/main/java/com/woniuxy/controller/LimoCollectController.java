package com.woniuxy.controller;

import com.woniuxy.service.CollectService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("insertCollect")
    public JSONResult insertCollect(Integer cId) throws Exception{
        Integer uId=1;
        collectService.insertCollect(cId,uId);
        return new JSONResult("200","success",null,null);
    }
}
