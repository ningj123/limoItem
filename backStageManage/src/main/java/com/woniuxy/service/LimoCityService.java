package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoCity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.LimoCityParam;
import com.woniuxy.param.PageParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
public interface LimoCityService extends IService<LimoCity> {
    /**
     * @Author zhuyuli
     * @Description //查询城市列表
     * @Date 2020/11/10 11:15
     * @Param [param]
     * @return java.lang.Object
     **/
    Page selectCItyListByPage(PageParam param)throws Exception;
    /**
     * @Author zhuyuli
     * @Description //根据城市查询列表
     * @Date 2020/11/10 11:58
     * @Param [param, city]
     * @return java.lang.Object
     **/
    Object selectByCityList(PageParam param, String city) throws Exception;
    /**
     * @Author zhuyuli
     * @Description 新增城市
     * @Date 2020/11/13 15:20
     * @Param [param]
     * @return void
     **/
    void insertCity(LimoCityParam param);
}
