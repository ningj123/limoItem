package com.woniuxy.controller;


import com.woniuxy.param.CampParam;
import com.woniuxy.service.LimoCampService;
import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuyanzu
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/limoCamp")
public class LimoCampController {
    @Resource
    private LimoCampService limoCampService;

    /**
     * 分页条件查询所有营地
     * @param campParam
     * @return
     * @throws Exception
     */
    @GetMapping("/selectcamp")
    public JSONResult selectCamp(CampParam campParam)throws Exception{
        return new JSONResult("200","success",null,limoCampService.selectCamp(campParam));
    }

    /**
     * 下架营地
     * @param cId
     * @param cStatus
     * @return
     * @throws Exception
     */
    @PutMapping("/stopCamp")
    public JSONResult stopCamp(Integer cId,Integer cStatus)throws Exception{
        return new JSONResult("200","success",null,null);
    }

    /**
     * 新增营地
     * @param campParam
     * @return
     * @throws Exception
     */
    @PostMapping("/insertCamp")
    public JSONResult insertCamp(CampParam campParam)throws Exception{
        limoCampService.insertCamp(campParam);
        return new JSONResult("200","success",null,null);
    }


}

