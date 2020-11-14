package com.woniuxy.controller;

import com.woniuxy.exception.TravelExecption;
import com.woniuxy.util.JSONResult;
import com.woniuxy.util.OnloadFile;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhuyuli
 * @description: 文件
 * @date: 2020/11/13 10:17
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/fileonLoad")
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public  JSONResult onLoad(@RequestParam("files") List<MultipartFile> files) throws Exception {
        if (files==null || files.size()<=0){
            throw new TravelExecption("文件不能为空");
        }
        String url = OnloadFile.insertMedia(files);
        System.out.println(url);
        return new JSONResult("200","success",null,url);
    }
}
