package com.woniuxy.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/9 9:26
 */

@Component
public class ResourceNotFound implements ErrorController {
    @Override
    public String getErrorPath() {


        return "/error";
    }
    /**
     * @Author zhuyuli
     * @Description 自定义404
     * @Date 2020/11/9 9:28
     * @Param [request]
     * @return ModelAndView
     **/
    @RequestMapping("error")
    public ModelAndView handler404(HttpServletRequest request) throws  Exception{
            ModelAndView view =new ModelAndView();
            if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
                FastJsonJsonView jsonView =new FastJsonJsonView();
                HashMap<String,String> map=new HashMap<String, String>();
                map.put("code","404");
                map.put("mess","资源没找到");
                jsonView.setAttributesMap(map);
                view.setView(jsonView);
            }else {
                view.setViewName("redirect:/error/404.html");
            }
            return view;
    }
}
