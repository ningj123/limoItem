package com.woniuxy.controller;


import com.woniuxy.param.JoinParam;
import com.woniuxy.service.LimoJoinService;
import com.woniuxy.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/join")
public class LimoJoinController {
    @Autowired
    private LimoJoinService limoJoinService;

    /**
     * 查询加盟信息
     * @param joinParam
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectJoin")
    public JSONResult selectJion(JoinParam joinParam)throws Exception{

        return new JSONResult("200","success",null,limoJoinService.selectJion(joinParam));
    }

    /**
     * 查询加盟详细信息
     * @param jId
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectJoinById")
    public JSONResult selectJoinById(Integer jId)throws Exception{
        return new JSONResult("200","success",null,limoJoinService.getById(jId));
    }

    /**
     * 根据加盟编号修改加盟状态
     * @param joinParam
     * @return
     * @throws Exception
     */
    @RequestMapping("/apply")
    public JSONResult updateStatus(JoinParam joinParam)throws Exception{
        limoJoinService.updateStatus(joinParam);
        return new JSONResult("200","success",null,null);
    }

}

