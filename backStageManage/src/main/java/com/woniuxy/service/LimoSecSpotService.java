package com.woniuxy.service;

import com.woniuxy.domain.LimoSecSpot;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
public interface LimoSecSpotService extends IService<LimoSecSpot> {
    /**
     * @Author zhuyuli
     * @Description 条件查询周边景点
     * @Date 2020/11/11 10:53
     * @Param [param]
     * @return java.lang.Object
     **/
    Object queryByParam(SortTypeParam param) throws  Exception;

    /**
     * @Author zhuyuli
     * @Description 新增周边景点
     * @Date 2020/11/12 10:52
     * @Param [param]
     * @return void
     **/
    void insertSport(SortParam param) throws  Exception;
    /**
     * @Author zhuyuli
     * @Description //更新周边景点
     * @Date 2020/11/13 15:27
     * @Param [param]
     * @return void
     **/
    void updateSport(SortParam param)throws  Exception;
}
