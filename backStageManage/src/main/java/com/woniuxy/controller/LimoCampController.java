package com.woniuxy.controller;


import com.woniuxy.domain.LimoManage;
import com.woniuxy.param.CampParam;
import com.woniuxy.param.LimoActivityParam;
import com.woniuxy.param.LimoJoinParam;
import com.woniuxy.param.LimoParam;
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
    public JSONResult selectLimos(Integer pType,PageVO pageVO) throws Exception{
//        Subject subject = SecurityUtils.getSubject();
//        LimoManage manager=(LimoManage)subject.getPrincipal();
        return new JSONResult("200","success",null,limoCampService.selectLimos(pType,1,pageVO));
    }

    /**
     * 查询某个房车的信息
     * @param pId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询某个房车的信息")
    @GetMapping("selectLimoById")
    public JSONResult selectLimoById(Integer pId) throws Exception{
        return new JSONResult("200","success",null,limoCampService.selectLimoById(pId));
    }

    /**
     * 删除某个房车或特色住宿
     * @param pId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除某个房车或特色住宿")
    @DeleteMapping("deleteLimoById")
    public JSONResult deleteLimoById(Integer pId) throws Exception{
        limoCampService.deleteLimoById(pId);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 更新某个房车或特色住宿信息
     * @param limoParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "更新某个房车或特色住宿信息")
    @PutMapping("updateLimo")
    public JSONResult updateLimo(LimoParam limoParam) throws Exception{
        limoCampService.updateLimo(limoParam);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 查询该管理员下营地内所有商品信息
     * @param pType
     * @param pageVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询该管理员下营地内所有商品信息")
    @GetMapping("selectProducts")
    public JSONResult selectProducts(Integer pType,PageVO pageVO) throws Exception{
//        Subject subject = SecurityUtils.getSubject();
//        LimoManage manager=(LimoManage)subject.getPrincipal();
        return new JSONResult("200","success",null,limoCampService.selectProducts(pType,1,pageVO));
    }

    /**
     * 新增商品
     * @param limoParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "新增商品")
    @PostMapping("insertProduct")
    public JSONResult insertProduct(LimoParam limoParam) throws Exception{
        limoCampService.insertProduct(limoParam);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 查询该营地管理员下的房车加盟申请
     * @param pageVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询该营地管理员下的房车加盟申请")
    @GetMapping("selectLimoJoin")
    public JSONResult selectLimoJoin(PageVO pageVO) throws Exception{
//        Subject subject = SecurityUtils.getSubject();
//        LimoManage manager=(LimoManage)subject.getPrincipal();
        return new JSONResult("200","success",null,limoCampService.selectLimoJoin(1,pageVO));
    }

    /**
     * 是否同意房车加盟
     * @param limoJoinParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "是否同意房车加盟")
    @PutMapping("limoJoin")
    public JSONResult updateJoin(LimoJoinParam limoJoinParam) throws Exception{
        limoCampService.updateJoin(limoJoinParam);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 查询该管理员所属营地的活动信息
     * @param aType
     * @param pageVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询该管理员所属营地的活动信息")
    @GetMapping("selectActivity")
    public JSONResult selectActivity(Integer aType,PageVO pageVO) throws Exception{
//        Subject subject = SecurityUtils.getSubject();
//        LimoManage manager=(LimoManage)subject.getPrincipal();
        return new JSONResult("200","success",null,limoCampService.selectActivity(aType,1,pageVO));
    }

    /**
     * 查询某个活动信息
     * @param aId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询某个活动信息")
    @GetMapping("selectActivityById")
    public JSONResult selectActivityById(Integer aId) throws Exception{
        return new JSONResult("200","success",null,limoCampService.selectActivityById(aId));
    }

    /**
     * 新增活动
     * @param limoActivityParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "新增活动")
    @PostMapping("insertActivity")
    public JSONResult insertActivity(LimoActivityParam limoActivityParam) throws Exception{
        limoCampService.insertActivity(limoActivityParam);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 删除活动
     * @param aId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除活动")
    @DeleteMapping("deleteActivity")
    public JSONResult deleteActivity(Integer aId) throws Exception{
        limoCampService.deleteActivity(aId);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 修改活动
     * @param limoActivityParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改活动")
    @PutMapping("updateActivity")
    public JSONResult updateActivity(LimoActivityParam limoActivityParam) throws Exception{
        limoCampService.updateActivity(limoActivityParam);
        return new JSONResult("200","success",null,null);
    }
}

