package com.woniuxy.controller;


import com.woniuxy.param.CampParam;
import com.woniuxy.param.LimoActivityParam;
import com.woniuxy.param.LimoJoinParam;
import com.woniuxy.param.LimoParam;
import com.woniuxy.service.LimoCampService;
import com.woniuxy.util.JSONResult;
import com.woniuxy.param.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "营地管理员")
public class LimoCampController {
    @Resource
    private LimoCampService limoCampService;

    /**
     * 分页条件查询所有营地
     * @param campParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "分页查询营地")
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
    @ApiOperation(value = "下架营地")
    @PutMapping("/stopCamp")
    public JSONResult stopCamp(Integer cId,Integer cStatus)throws Exception{
        limoCampService.stopCamp(cId,cStatus);
        return new JSONResult("200","success",null,null);
    }

    /**
     * 新增营地
     * @param campParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "新增营地")
    @PostMapping("/insertCamp")
    public JSONResult insertCamp(CampParam campParam)throws Exception{
        limoCampService.insertCamp(campParam);
        return new JSONResult("200","success",null,null);
    }
    /**
     * 查询该营地管理员的所有营地
     * @param pageVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询该营地管理员的所有营地")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",dataType = "Integer",defaultValue = "3")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId",value = "营地id",dataType = "Integer",defaultValue = "1")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId",value = "营地id",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "cName",value = "营地名称",dataType = "String",defaultValue = "花马山房车露营基地"),
            @ApiImplicitParam(name = "cAddress",value = "营地地址",dataType = "String",defaultValue = "重庆市沙坪坝区大学城重庆师范大学西部"),
            @ApiImplicitParam(name = "cPhone",value = "营地电话",dataType = "String",defaultValue = "13382321323"),
            @ApiImplicitParam(name = "cOpenTime",value = "营地营业时间",dataType = "String",defaultValue = "8：30-22：00"),
            @ApiImplicitParam(name = "cSpecial",value = "营地特色",dataType = "String",defaultValue = "篝火晚会"),
            @ApiImplicitParam(name = "cCity",value = "营地所在城市",dataType = "String",defaultValue = "重庆"),
            @ApiImplicitParam(name = "cDes",value = "营地描述",dataType = "String",defaultValue = "舒服"),
            @ApiImplicitParam(name = "cImages",value = "营地图片路径",dataType = "String",defaultValue = "huamashan.jpg"),
            @ApiImplicitParam(name = "cStatus",value = "营地状态",dataType = "Integer",defaultValue = "0"),
            @ApiImplicitParam(name = "mId",value = "营地所属哪位管理员",dataType = "Integer",defaultValue = "1")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId",value = "营地id",dataType = "Integer",defaultValue = "1")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pType",value = "房车类型（2）",dataType = "Integer",defaultValue = "2"),
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",dataType = "Integer",defaultValue = "3")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pId",value = "商品id",dataType = "Integer",defaultValue = "6")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pId",value = "商品id",dataType = "Integer",defaultValue = "6")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pId",value = "商品id",dataType = "Integer",defaultValue = "8"),
            @ApiImplicitParam(name = "pName",value = "商品名称",dataType = "String",defaultValue = "Hobby 455 UF 豪华版"),
            @ApiImplicitParam(name = "pInven",value = "商品库存",dataType = "Integer",defaultValue = "9999"),
            @ApiImplicitParam(name = "pOldPrice",value = "商品原价",dataType = "double",defaultValue = "3299"),
            @ApiImplicitParam(name = "pNewPrice",value = "商品现价",dataType = "double",defaultValue = "2899"),
            @ApiImplicitParam(name = "pSellPrice",value = "商品售价（房车购买）",dataType = "double"),
            @ApiImplicitParam(name = "pImages",value = "商品图片",dataType = "String",defaultValue = "Hobby455.png"),
            @ApiImplicitParam(name = "pDes",value = "商品描述",dataType = "String",defaultValue = "豪华舒适,牛逼得很"),
            @ApiImplicitParam(name = "pType",value = "商品类型（2）",dataType = "Integer",defaultValue = "2"),
            @ApiImplicitParam(name = "urId",value = "无",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "cId",value = "营地id",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pStatus",value = "商品状态",dataType = "Integer",defaultValue = "0"),
            @ApiImplicitParam(name = "cCity",value = "城市名",dataType = "String",defaultValue = "重庆")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pType",value = "商品类型",dataType = "Integer",defaultValue = "0"),
            @ApiImplicitParam(name = "mId",value = "所属人id",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示几条",dataType = "Integer",defaultValue = "3")
    })
    @GetMapping("selectProducts")
    public JSONResult selectProducts(Integer mId,Integer pType,PageVO pageVO) throws Exception{
//        Subject subject = SecurityUtils.getSubject();
//        LimoManage manager=(LimoManage)subject.getPrincipal();
        return new JSONResult("200","success",null,limoCampService.selectProducts(pType,mId,pageVO));
    }

    /**
     * 新增商品
     * @param limoParam
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "新增商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pId",value = "商品id",dataType = "Integer",defaultValue = "8"),
            @ApiImplicitParam(name = "pName",value = "商品名称",dataType = "String",defaultValue = "Hobby 455 UF 豪华版"),
            @ApiImplicitParam(name = "pInven",value = "商品库存",dataType = "Integer",defaultValue = "9999"),
            @ApiImplicitParam(name = "pOldPrice",value = "商品原价",dataType = "double",defaultValue = "4699"),
            @ApiImplicitParam(name = "pNewPrice",value = "商品现价",dataType = "double",defaultValue = "4256"),
            @ApiImplicitParam(name = "pSellPrice",value = "商品售价（房车购买）",dataType = "double"),
            @ApiImplicitParam(name = "pImages",value = "商品图片",dataType = "String",defaultValue = "Hobby455.png"),
            @ApiImplicitParam(name = "pDes",value = "商品描述",dataType = "String",defaultValue = "豪华舒适,牛逼得很"),
            @ApiImplicitParam(name = "pType",value = "商品类型（2）",dataType = "Integer",defaultValue = "2"),
            @ApiImplicitParam(name = "urId",value = "无",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "cId",value = "营地id",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pStatus",value = "商品状态",dataType = "Integer",defaultValue = "0"),
            @ApiImplicitParam(name = "cCity",value = "城市名",dataType = "String",defaultValue = "重庆")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",dataType = "Integer",defaultValue = "3")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jId", value = "房车或营地加盟人的id", dataType = "String",defaultValue = "1"),
            @ApiImplicitParam(name = "jStatus", value = "加盟后状态(0正在审核1同意2拒绝)", dataType = "Integer",defaultValue = "1")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aType", value = "活动类型", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "mId", value = "管理员id", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer",defaultValue = "3")
    })
    @GetMapping("selectActivity")
    public JSONResult selectActivity(Integer mId,Integer aType,PageVO pageVO) throws Exception{
//        Subject subject = SecurityUtils.getSubject();
//        LimoManage manager=(LimoManage)subject.getPrincipal();
        return new JSONResult("200","success",null,limoCampService.selectActivity(aType,mId,pageVO));
    }

    /**
     * 查询某个活动信息
     * @param aId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询某个活动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aId", value = "活动id", dataType = "Integer",defaultValue = "2")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aName", value = "活动名称", dataType = "String",defaultValue = "营地运动会"),
            @ApiImplicitParam(name = "aInven", value = "活动库存", dataType = "Integer",defaultValue = "20"),
            @ApiImplicitParam(name = "aImages", value = "活动图片", dataType = "String",defaultValue = ""),
            @ApiImplicitParam(name = "aDes", value = "活动描述", dataType = "String",defaultValue = "选出全能运动员"),
            @ApiImplicitParam(name = "aPrice", value = "活动价格", dataType = "double",defaultValue = "79"),
            @ApiImplicitParam(name = "aType", value = "活动类型", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "aSellNum", value = "活动出售数量", dataType = "Integer",defaultValue = "20"),
            @ApiImplicitParam(name = "aSellTime", value = "活动开售时间", dataType = "String",defaultValue = "2021-01-04"),
            @ApiImplicitParam(name = "aStartTime", value = "活动开始时间", dataType = "String",defaultValue = "2021-01-15"),
            @ApiImplicitParam(name = "aEndTime", value = "活动结束时间", dataType = "String",defaultValue = "2021-01-15"),
            @ApiImplicitParam(name = "cId", value = "营地id", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "aStatus", value = "活动状态", dataType = "Integer",defaultValue = "0"),
            @ApiImplicitParam(name = "aCity", value = "活动城市", dataType = "String",defaultValue = "重庆")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aId", value = "活动id", dataType = "Integer",defaultValue = "2")
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aId", value = "活动id", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "aName", value = "活动名称", dataType = "String",defaultValue = "夏叶河营地活动"),
            @ApiImplicitParam(name = "aInven", value = "活动库存", dataType = "Integer",defaultValue = "120"),
            @ApiImplicitParam(name = "aImages", value = "活动图片", dataType = "String",defaultValue = ""),
            @ApiImplicitParam(name = "aDes", value = "活动描述", dataType = "String",defaultValue = "这是夏叶河营地活动，是您轻松愉快"),
            @ApiImplicitParam(name = "aPrice", value = "活动价格", dataType = "double",defaultValue = "100"),
            @ApiImplicitParam(name = "aType", value = "活动类型", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "aSellNum", value = "活动出售数量", dataType = "Integer",defaultValue = "0"),
            @ApiImplicitParam(name = "aSellTime", value = "活动开售时间", dataType = "String",defaultValue = "2020-12-02"),
            @ApiImplicitParam(name = "aStartTime", value = "活动开始时间", dataType = "String",defaultValue = "2020-12-12"),
            @ApiImplicitParam(name = "aEndTime", value = "活动结束时间", dataType = "String",defaultValue = "2020-12-14"),
            @ApiImplicitParam(name = "cId", value = "营地id", dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "aStatus", value = "活动状态", dataType = "Integer",defaultValue = "0"),
            @ApiImplicitParam(name = "aCity", value = "活动城市", dataType = "String",defaultValue = "重庆")
    })
    @PutMapping("updateActivity")
    public JSONResult updateActivity(LimoActivityParam limoActivityParam) throws Exception{
        limoCampService.updateActivity(limoActivityParam);
        return new JSONResult("200","success",null,null);
    }
}

