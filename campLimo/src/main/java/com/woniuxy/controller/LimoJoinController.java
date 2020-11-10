package com.woniuxy.controller;

import com.woniuxy.param.JoinParam;
import com.woniuxy.service.JoinService;
import com.woniuxy.util.JSONResult;
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
