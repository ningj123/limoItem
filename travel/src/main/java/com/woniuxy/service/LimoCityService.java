package com.woniuxy.service;

import com.woniuxy.doman.LimoCity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.PageParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
public interface LimoCityService extends IService<LimoCity> {
    /**
     * @Author zhuyuli
     * @Description //查询城市列表
     * @Date 2020/11/10 11:15
     * @Param [param]
     * @return java.lang.Object
     **/
    Object selectCItyListByPage(PageParam param);
    /**
     * @Author zhuyuli
     * @Description //根据城市查询列表
     * @Date 2020/11/10 11:58
     * @Param [param, city]
     * @return java.lang.Object
     **/
    Object selectByCityList(PageParam param, String city);
    /**
     * @Author zhuyuli
     * @Description //根据城市名字查询城市
     * @Date 2020/11/10 14:16
     * @Param [city]
     * @return java.lang.Object
     **/
    Object queryByCity(String city);
}
