package com.woniuxy.controller;

import com.alibaba.fastjson.JSON;
import com.woniuxy.feign.ProductFeign;
import com.woniuxy.param.MyProductParam;
import com.woniuxy.service.CampService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 查询所有营地地址
     * @return
     * @throws Exception
     */
    @GetMapping("selectCamps")
    public JSONResult selectCamps() throws Exception{
        return new JSONResult("200","success",campService.selectCamps(),null);
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
    public JSONResult selectProductByCid(MyProductParam product)throws Exception{
        System.out.println(product);
        JSONResult result = productFeign.selectProduct(product);
        return result;
    }

    /**
     * 房车或特色住宿或可以购买房车的信息
     * @param pId
     * @return
     */
    @GetMapping("selectLimos")
    public JSONResult selectLimos(Integer pId) throws Exception{
        JSONResult result = productFeign.selectProductById(pId);
        return result;
    }

    /**
     * 查询订单中未使用状态的时间
     * @param pId
     * @return
     * @throws Exception
     */
    @GetMapping("selectOrderTime")
    public JSONResult selectOrderTime(Integer pId)throws Exception{
        JSONResult result= productFeign.selectOrderDetailByPid(pId);
        return result;
    }

}

