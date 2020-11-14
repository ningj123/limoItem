package com.woniuxy.util;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhuyuli
 * @description: 文件上传
 * @date: 2020/11/13 10:02
 */

public class OnloadFile {
    /**
     * @Author zhuyuli
     * @Description //文件或图片下载
     * @Date 2020/11/13 10:12
     * @Param json字符串
     * @return java.lang.String
     **/
    public static String insertMedia(List<MultipartFile> files) throws Exception{
        ArrayList<String> list=new ArrayList<>();
            try {
                for (MultipartFile mu : files) {
                    //获取文件名
                    String string = mu.getOriginalFilename();
                    //截取后缀
                    String ext = string.substring(string.lastIndexOf("."));
                    //生成文件名
                    String filename= UUID.randomUUID().toString()+ext;
                    //存放的路径
                    String path="D:\\UserData\\photo"+filename.replace("\\",File.separator);

                    //获取文件输入，获取文件源，file(保存地址，文件命名）
                    FileUtils.copyInputStreamToFile(mu.getInputStream(), new File("D:\\UserData\\photo".replace("\\",File.separator),filename));
                    list.add(path);
                }
                //文件路径保存到数据库中
            } catch (Exception e) {
                throw new Exception("文件上传失败");
            }
         //转出json字符串
        String s = JSONObject.parseObject(JSON.toJSONString(list), String.class);
        return s;
    }
}
