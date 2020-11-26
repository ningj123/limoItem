package com.woniuxy.service;

import com.woniuxy.doman.LimoCamp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.doman.LimoManage;
import com.woniuxy.param.PageParam;
import com.woniuxy.param.PersonParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
public interface LimoCampService extends IService<LimoCamp> {
/**
 * @Author zhuyuli
 * @Description //根据权限查询营地管理员下的营地列表
 * @Date 2020/11/24 18:49
 * @Param [id]
 * @return java.util.List
 **/
    List selectByCamp(LimoManage limoManage);
    /**
     * @Author zhuyuli
     * @Description //根据营地管理员查询
     * @Date 2020/11/24 19:40
     * @Param [limoManage]
     * @return java.lang.Object
     **/
    List selectByCampCar(LimoManage limoManage, Integer cid);
    /**
     * @Author zhuyuli
     * @Description //查询房车使用情况
     * @Date 2020/11/24 20:15
     * @Param [cid]
     * @return java.lang.Object
     **/
    List selectByStatus(Integer cid);
    /**
     * @Author zhuyuli
     * @Description //新增住房信息
     * @Date 2020/11/24 20:39
     * @Param [per]
     * @return void
     **/
    void insertAppDetail(PersonParam per);
    /**
     * @Author zhuyuli
     * @Description //查询住房信息
     * @Date 2020/11/24 20:39
     * @Param [per]
     * @return void
     **/
    List<?> selectByHtol(Integer id);
/**
 * @Author zhuyuli
 * @Description //查询住宿情况
 * @Date 2020/11/25 12:04
 * @Param [id]
 * @return java.util.List<?>
 **/
    List<?> selectByHtolList(Integer id);
}
