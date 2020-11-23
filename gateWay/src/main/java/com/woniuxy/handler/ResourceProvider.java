package com.woniuxy.handler;

import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ResourceProvider
 * @Author shadow
 * @Date 2020/11/20 10:03
 * @Description TODO
 **/
@Component
public class ResourceProvider implements SwaggerResourcesProvider {
    //该接口的方法就是获取分类数据的集合
    @Override
    public List<SwaggerResource> get() {
        return Arrays.asList(
                createSwaggerResource("周边旅游","/travel/v2/api-docs","2.0"),
                createSwaggerResource("营地住宿","/camp/v2/api-docs","2.0"),
                createSwaggerResource("营地商品","/campFoods/v2/api-docs","2.0"),
                createSwaggerResource("营地活动","/campActivities/v2/api-docs","2.0"),
                createSwaggerResource("后台管理","/back/v2/api-docs","2.0")
        );
    }

    //集合里面的每一个数据就是一个对象
    private SwaggerResource createSwaggerResource(String name,String url,String version) {
        SwaggerResource sr = new SwaggerResource();
        sr.setName(name);
        sr.setLocation(url);
        sr.setSwaggerVersion(version);
        return sr;
    }
}
