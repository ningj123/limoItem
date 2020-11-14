package com.woniuxy.service;

import com.woniuxy.domain.LimoBanner;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.BanParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
public interface LimoBannerService extends IService<LimoBanner> {
    Object queryBannerList(Integer pageSize, Integer pageNum,Integer type) throws Exception;

    void updateBannerById(BanParam param) throws  Exception;
}
