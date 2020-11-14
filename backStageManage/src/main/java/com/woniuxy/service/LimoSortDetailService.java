package com.woniuxy.service;

import com.woniuxy.domain.LimoSortDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.TypeParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
public interface LimoSortDetailService extends IService<LimoSortDetail> {
    /**
     * @Author zhuyuli
     * @Description 根据类型或关键字分页查询列表
     * @Date 2020/11/10 9:50
     * @Param [param]
     * @return java.lang.Object
     **/
    public Object selectByType(TypeParam param) throws Exception;
    /**
     * @Author zhuyuli
     * @Description //查询所有列表
     * @Date 2020/11/13 14:54
     * @Param []
     * @return java.util.List
     **/
    List queryAll()throws Exception;
    /**
     * @Author zhuyuli
     * @Description //更新旅游文章
     * @Date 2020/11/13 15:02
     * @Param [param]
     * @return void
     **/
    void updateTravelSort(LSDParam param)throws Exception;
}
