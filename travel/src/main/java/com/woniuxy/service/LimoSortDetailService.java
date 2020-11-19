package com.woniuxy.service;

import com.woniuxy.doman.LimoSortDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.TypeParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-07
 */
public interface LimoSortDetailService extends IService<LimoSortDetail> {
    /**
     * @Author zhuyuli
     * @Description //查询旅游攻略（4个指南）
     * @Date 2020/11/9 17:32
     * @Param []
     * @return java.lang.Object
     **/
    Object selectAll()throws Exception;
  /**
   * @Author zhuyuli
   * @Description 根据类型或关键字分页查询列表
   * @Date 2020/11/10 9:50
   * @Param [param]
   * @return java.lang.Object
   **/
    Object selectByType(TypeParam param)throws Exception;
    /**
     * @Author zhuyuli
     * @Description 查询全部文章
     * @Date 2020/11/11 15:08
     * @Param []
     * @return java.util.List<com.woniuxy.doman.LimoSortDetail>
     **/
    List queryAll();
    /**
     * @Author zhuyuli
     * @Description 根据ID查询
     * @Date 2020/11/12 9:44
     * @Param [id]
     * @return com.woniuxy.doman.LimoSortDetail
     **/
    Object selectById(Integer id)throws Exception;
    /**
     * @Author zhuyuli
     * @Description //修改旅游指南
     * @Date 2020/11/13 15:06
     * @Param [param]
     * @return void
     **/
    void updateTravelSort(LSDParam param)throws Exception;
}
