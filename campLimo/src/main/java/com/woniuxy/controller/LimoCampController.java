package com.woniuxy.controller;

import com.woniuxy.service.CampService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shadow
 * @since 2020-11-09
 */
@RestController
@RequestMapping("limo/camp")
public class LimoCampController {
    @Autowired
    private CampService campService;
    @GetMapping("selectCampsByCity")
    public JSONResult selectCampsByCity(String city, PageVO pageVO) throws Exception{
        return new JSONResult("200","success",null,campService.selectCampsByCity(city,pageVO));
    }
    @GetMapping("selectCampById")
    public JSONResult selectCampById(Integer id) throws Exception{
        return new JSONResult("200","success",null,campService.selectCampById(id));
    }
}

