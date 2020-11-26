package com.woniuxy.controller;


import com.woniuxy.doman.LimoManage;
import com.woniuxy.exception.BackExecption;
import com.woniuxy.param.PageParam;
import com.woniuxy.param.PersonParam;
import com.woniuxy.service.LimoCampService;
import com.woniuxy.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import java.util.List;

/**
 * <p>
 *  营地前端控制器
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/limoCamp")
@Api(tags = "房车管理")
public class LimoCampController {
    @Resource
    private LimoCampService limoCampService;
    /**
     * @Author zhuyuli
     * @Description //根据营地管理员根据权限查询下面的所有营地
     * @Date 2020/11/24 18:45
     * @Param []
     * @return com.woniuxy.util.JSONResult
     **/
    @GetMapping("/selectByCamp")
    public JSONResult query(){
       // Subject subject = SecurityUtils.getSubject();
        // LimoManage limoManage = (limoManage)subject.getPrincipal();
        LimoManage limoManage=new LimoManage();
        limoManage.setMName("张三");
        limoManage.setMPhone("1234");
        limoManage.setMId(2);
        limoManage.setRId(2);
        return new JSONResult("200","success",limoCampService.selectByCamp(limoManage),null);
    }
    /**
     * @Author zhuyuli
     * @Description //根据管理员的权限查询营地下的房车
     * @Date 2020/11/24 19:39
     * @Param []
     * @return com.woniuxy.util.JSONResult
     **/
    @ApiOperation("根据管理员的权限查询营地下的房车")
    @GetMapping("/selectByCampCar")
    public JSONResult selectByCampCar(Integer cid) throws Exception{
        // Subject subject = SecurityUtils.getSubject();
        // LimoManage limoManage = (limoManage)subject.getPrincipal();

        LimoManage limoManage=new LimoManage();
        limoManage.setMName("张三");
        limoManage.setMPhone("1234");
        limoManage.setMId(2);
        limoManage.setRId(2);
        if(limoManage==null){
            throw  new BackExecption("登陆超时");
        }
        return new JSONResult("200","success",limoCampService.selectByCampCar(limoManage,cid),null);
    }
    /**
     * @Author zhuyuli
     * @Description //根据房车查询使用情况
     * @Date 2020/11/24 20:14
     * @Param [cid, param]
     * @return com.woniuxy.util.JSONResult
     **/
    @ApiOperation("根据房车查询使用情况")
    @GetMapping("/selectByStatus")
    public JSONResult selectByStatus(Integer cid) throws Exception{
        // Subject subject = SecurityUtils.getSubject();
        // LimoManage limoManage = (limoManage)subject.getPrincipal();

        //LimoManage limoManage=new LimoManage();
        //limoManage.setMName("张三");
        //limoManage.setMPhone("1234");
        //limoManage.setMId(2);
        //limoManage.setRId(2);
        //if(limoManage==null){
        //    throw  new BackExecption("登陆超时");
        //}
        return new JSONResult("200","success",limoCampService.selectByStatus(cid),null);
    }
    /**
     * @Author zhuyuli
     * @Description //新增房车
     * @Date 2020/11/24 20:25
     * @Param [cid]
     * @return com.woniuxy.util.JSONResult
     **/
    @ApiOperation("新增房车住宿")
    @PostMapping("/insertCar")
    public JSONResult insertCar(Integer cid) throws Exception{
        // Subject subject = SecurityUtils.getSubject();
        // LimoManage limoManage = (limoManage)subject.getPrincipal();

        //LimoManage limoManage=new LimoManage();
        //limoManage.setMName("张三");
        //limoManage.setMPhone("1234");
        //limoManage.setMId(2);
        //limoManage.setRId(2);
        //if(limoManage==null){
        //    throw  new BackExecption("登陆超时");
        //}
        return new JSONResult("200","success",limoCampService.selectByStatus(cid),null);
    }
    /**
     * @Author zhuyuli
     * @Description //新增住房信息
     * @Date 2020/11/24 20:39
     * @Param [per]
     * @return com.woniuxy.util.JSONResult
     **/
    @ApiOperation("新增住房用户信息")
    @PostMapping("/insertAppDetail")
    public JSONResult insertAppDetail(@RequestBody  PersonParam per) throws Exception{
        limoCampService.insertAppDetail(per);
        return new JSONResult("200","success",null,null);
    }
    @ApiOperation("根据房车住宿查询住宿信息")
    @GetMapping("/selectByHtol")
    public JSONResult selectByHtol(Integer id) throws Exception{

        return new JSONResult("200","success",limoCampService.selectByHtol(id),null);
    }
    /**
     * @Author zhuyuli
     * @Description //查询住宿情况
     * @Date 2020/11/25 12:04
     * @Param [id]
     * @return java.util.List<?>
     **/
    @ApiOperation("根据房车信息查询住宿情况")
    @GetMapping("/selectByHtolList")
    public JSONResult selectByHtolList(Integer id) throws Exception{

        return new JSONResult("200","success",limoCampService.selectByHtolList(id),null);
    }
}

