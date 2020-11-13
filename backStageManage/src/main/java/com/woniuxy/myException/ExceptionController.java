package com.woniuxy.myException;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExceptionController
 * @Author shadow
 * @Date 2020/11/12 15:56
 * @Description TODO
 **/
@Controller
public class ExceptionController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("error")
    public ModelAndView DataSourceNotFind(HttpServletRequest request) throws Exception{
        ModelAndView view = new ModelAndView();
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            FastJsonJsonView jsonView = new FastJsonJsonView();
            Map<String,String> map = new HashMap<String,String>();
            map.put("code", "404");
            map.put("message", "找不到资源");
            jsonView.setAttributesMap(map);
            view.setView(jsonView);
        }
        return view;
    }
}
