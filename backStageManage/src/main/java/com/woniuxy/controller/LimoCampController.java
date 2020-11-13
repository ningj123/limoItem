package com.woniuxy.controller;


import com.woniuxy.domain.LimoManage;
import com.woniuxy.param.CampParam;
import com.woniuxy.service.LimoCampService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.vo.PageVO;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
@RestController
@RequestMapping("back/limoCamp")
public class LimoCampController {
    @Resource
    private LimoCampService limoCampService;

    /**
     * 查询该营地管理员的所有营地
     * @param pageVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询该营地管理员的所有营地")
    @GetMapping("selectCamps")
    public JSONResult selectCamps(PageVO pageVO) throws Exception{
//        Subject subject = SecurityUtils.getSubject();
//        LimoManage manager=(LimoManage)subject.getPrincipal();
        return new JSONResult("200","success",null,limoCampService.selectCamps(1,pageVO));
    }

    /**
     * 查询一个营地信息
     * @param cId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询一个营地信息")
    @GetMapping("selectCampByCid")
    public JSONResult selectCampByCid(Integer cId) throws Exception{
        return new JSONResult("200","success",null,limoCampService.selectCampByCid(cId));
    }

    /**
     * 更新营地信息
     * @param campParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "更新营地信息")
    @PutMapping("updateCamp")
    public JSONResult updateCamp(CampParam campParam) throws Exception{
        limoCampService.updateCamp(campParam);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 下架营地
     * @param cId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "下架营地")
    @DeleteMapping("deleteCampByCid")
    public JSONResult deleteCampByCid(Integer cId) throws Exception{
        limoCampService.deleteCampByCid(cId);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 查询房车
     * @param pageVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询房车")
    @GetMapping("selectLimos")
    public JSONResult selectLimos(PageVO pageVO) throws Exception{
        return new JSONResult("200","success",null,null);
    }
}

