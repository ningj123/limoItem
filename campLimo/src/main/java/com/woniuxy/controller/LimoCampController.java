package com.woniuxy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.woniuxy.feign.ProductFeign;
import com.woniuxy.param.ProductParam;
import com.woniuxy.service.CampService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @Resource
    private ProductFeign productFeign;
    /**
     * 根据城市分页查询该城市的营地
     * @param city
     * @param pageVO
     * @return
     * @throws Exception
     */
    @GetMapping("selectCampsByCity")
    public JSONResult selectCampsByCity(String city,String context, PageVO pageVO) throws Exception{
        return new JSONResult("200","success",null,campService.selectCampsByCity(city,context,pageVO));
    }
    /**
     * 根据城市分页查询该城市的营地(feign调用)
     * @param city
     * @param pageVO
     * @return
     * @throws Exception
     */
    @GetMapping("selectCampsCity")
    public String selectCampsCity(String city,String context, PageVO pageVO) throws Exception{
        return JSON.toJSONString(campService.selectCampsByCity(city,context,pageVO));
    }

    /**
     * 根据营地id查询营地信息
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("selectCampById")
    public JSONResult selectCampById(Integer id) throws Exception{
        return new JSONResult("200","success",null,campService.selectCampById(id));
    }
    /**
     * 根据营地id查询营地信息(feign调用)
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("selectCampId")
    public String selectCampId(Integer id) throws Exception{
        return JSON.toJSONString(campService.selectCampById(id));
    }

    /**
     * 根据营地id查出不同类型的商品
     * @param product
     * @return
     * @throws Exception
     */
    @GetMapping("selectProductByCid")
    public JSONResult selectProductByCid(ProductParam product)throws Exception{
        PageInfo pageInfo = JSON.parseObject(productFeign.selectProductByCid(product), PageInfo.class);
        return new JSONResult("200","success",null,pageInfo);
    }
}

