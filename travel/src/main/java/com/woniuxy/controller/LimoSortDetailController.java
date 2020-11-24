package com.woniuxy.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.exception.TravelExecption;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.LSDParam1;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.woniuxy.util.IpAddress;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import io.swagger.annotations.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-07
 */
@RestController
@RequestMapping("/limoSortDetail")
@Api(tags="旅游指南")
@CrossOrigin
public class LimoSortDetailController {
    @Resource
    private LimoSortDetailService limoSortDetailService;
    @Autowired
    private RedisTemplate<String,String>  redisTemplate;

    //新增旅游文章(json格式)
    @ApiOperation(value = "新增旅游文章(json格式)")
    @PostMapping
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public JSONResult insertTravelSort( @RequestHeader("x-token")String token,@RequestBody LSDParam1 param) throws Exception{
        Map<String, Object> map = LoginUtil.parseToken(token);

        limoSortDetailService.saveDetail(param,map);
        return new JSONResult("200","success",null,null);
    }
    //新增旅游文章(text格式)
   // @PostMapping("/sort")
    //@ApiOperation(value = "新增旅游文章(text格式)")
    public JSONResult insertSort(String param)throws Exception{
        LimoSortDetail limoSortDetail = JSONObject.parseObject(param, LimoSortDetail.class);
        limoSortDetailService.save(limoSortDetail);
        return new JSONResult("200","success",null,null);
    }
    //查询旅游攻略（4个指南）
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询旅游攻略（4个指南）")
    public JSONResult selectAll( )throws Exception{

        return new JSONResult("200","success",null,limoSortDetailService.selectAll());
    }

    //根据类别查询旅游指南文章的列表，
    @GetMapping("/selectByType")
    @ApiOperation(value = "根据类别查询旅游指南文章的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "类别"),
            @ApiImplicitParam(name = "keyWord",value = "关键字"),
    })
    public JSONResult selectByType(TypeParam param)throws Exception{
        Object obj=limoSortDetailService.selectByType(param);
        return new JSONResult("200","success",null,obj);
    }
    //根据ID查询
    @GetMapping("/selectById")
    @ApiOperation(value = "根据ID查询旅游指南文章")
    @ApiParam(name = "id",value = "主键")
    public JSONResult selectById(Integer id, HttpServletRequest request)throws Exception{
            if(id<0){
               throw new TravelExecption("参数不正确");
    }


        return new JSONResult("200","success",null,limoSortDetailService.selectById(id,request));
    }
    //查询所有
    @GetMapping("/queryAllByDetail")
    @ApiOperation(value = "查询所有旅游文章")
    public JSONResult queryAll(){
        List lits=limoSortDetailService.queryAll();

        return  new JSONResult("200","success",lits,null);
    }
    //修改旅游文章(json格式)
    @ApiOperation(value = "修改旅游文章(json格式)")
    @PostMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "soDId",value = "id",defaultValue = "1"),
            @ApiImplicitParam(name = "soDName",value = "标题",defaultValue = "重庆鸟瞰"),
            @ApiImplicitParam(name = "soDDes",value = "描述",defaultValue = "sdvfd糯米藕三方都快来撒") ,
            @ApiImplicitParam(name = "soDImages",value = "图片路径",defaultValue = "[\"ninmdjama.jpg\",\"ninmdjama.jpg\"]"),
            @ApiImplicitParam(name = "soDType",value = "类别(0 热门 1 营地 2 美食 3 景区)",defaultValue = "1") ,
            @ApiImplicitParam(name = "soDDes",value = "描述",defaultValue = "·被称为“天下九塞”之一，是明长城景色中的精华，海拔高达1015米，也是居庸关的前哨。·分为南长城和北长城两部分，南长城有7处敌楼，游客相对较少，北长城有12处敌楼，比较难爬。·是游览北京的必到之处，尼克松、撒切尔夫人等三百多位世界知名人士曾登上长城。·是5A级景区，被联合国教科文组织列入《世界文化遗产名录》，热度仅次于天安门广场。这里还包含景点： 中国长城博物馆 詹天佑纪念馆 南一楼 北二楼 八达岭古长城自然风景区 红叶岭 近枫台 青龙桥 八达岭国际友谊林 神威大将军炮 最美赏红城墙 最美赏红箭窗 南六楼 南五楼 八达岭熊乐园 北十一楼 北八楼 北门锁钥 八达岭长城望京文化广场 红叶树王 缘") ,
            @ApiImplicitParam(name = "soDCity",value = "城市",defaultValue = "重庆"),
            @ApiImplicitParam(name = "soId",value = "关联城市的id",defaultValue = "1"),
            @ApiImplicitParam(name = "soDKeyword",value = "关键字",defaultValue = "景区攻略,美食攻略"),
            @ApiImplicitParam(name = "soDStatus",value = "状态(0 开放 1 不开放)",defaultValue = "0"),

    })
    public JSONResult updateTravelSort(@RequestBody LSDParam param) throws Exception{

        limoSortDetailService.updateTravelSort(param);
        return new JSONResult("200","success",null,null);
    }
}

