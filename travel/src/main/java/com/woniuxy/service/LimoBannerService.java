package com.woniuxy.service;

import com.woniuxy.doman.LimoBanner;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.BanParam;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
public interface LimoBannerService extends IService<LimoBanner> {
    /**
     * @Author zhuyuli
     * @Description 分页查询广告列表
     * @Date 2020/11/9 9:44
     * @Param 广告集合
     * @return com.woniuxy.util.JSONResult
     **/
    Object queryBannerList(Integer pageSize, Integer pageNum, Integer type)throws Exception;
    /**
     * @Author zhuyuli
     * @Description 根据类型查询广告
     * @Date 2020/11/9 14:04
     * @Param [type]
     * @return LimoBanner
     **/
    List<LimoBanner> queryBannerByType(Integer type)throws Exception;
    /**
     * @Author zhuyuli
     * @Description //更新广告
     * @Date 2020/11/9 14:19
     * @Param 广告参数实体
     * @return void
     **/
    void updateBannerById(BanParam param)throws  Exception;
}
