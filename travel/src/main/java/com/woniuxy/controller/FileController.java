package com.woniuxy.controller;

import com.woniuxy.client.CampClient;
import com.woniuxy.exception.TravelExecption;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.LoginUtil;
import com.woniuxy.util.OnloadFile;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuyuli
 * @description: 文件
 * @date: 2020/11/13 10:17
 */
@RestController
@Api(tags="文件上传")
@RequestMapping("/file")
public class FileController {
    @Autowired
    private CampClient campClient;

    @PostMapping("/fileonLoad")
    @ApiOperation("文件上传的接口")
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public  JSONResult onLoad(@RequestParam("files") List<MultipartFile> files) throws Exception {
        if (files==null || files.size()<=0){
            throw new TravelExecption("文件不能为空");
        }
        String url = OnloadFile.insertMedia(files);
        System.out.println(url);
        return new JSONResult("200","success",null,url);
    }

    //@GetMapping("/select")
    //@ApiOperation("调用其他接口的fen,根据主键获取营地信息")
    //public  JSONResult select(Integer id) throws Exception {
    //
    //    JSONResult jsonResult = campClient.selectCampById(id);
    //
    //    return new JSONResult("200","success",null,jsonResult.getObj());
    //}
}
