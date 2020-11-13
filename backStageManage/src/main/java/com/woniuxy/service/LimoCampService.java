package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoCamp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.CampDto;
import com.woniuxy.param.CampParam;
import com.woniuxy.util.JSONResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuyanzu
 * @since 2020-11-12
 */
public interface LimoCampService extends IService<LimoCamp> {
    /**
     * 分页条件查询所有营地
     * @param campParam
     * @return
     * @throws Exception
     */
    Page<CampDto> selectCamp(CampParam campParam)throws Exception;

    /**
     * 下架营地
     * @param cId
     * @param cStatus
     * @throws Exception
     */
    public void stopCamp(Integer cId, Integer cStatus)throws Exception;

    /**
     * 新增营地
     * @param campParam
     * @throws Exception
     */
    public void insertCamp(CampParam campParam)throws Exception;
}
