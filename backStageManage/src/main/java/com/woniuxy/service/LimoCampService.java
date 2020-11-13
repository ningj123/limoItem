package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.woniuxy.domain.LimoCamp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.CampDto;
import com.woniuxy.param.CampParam;
import com.woniuxy.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shadow
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
     /** 查询该营地管理员的所有营地
     * @param mId
     * @param pageVO
     * @return
     * @throws Exception
     */
    PageInfo<CampDto> selectCamps(Integer mId, PageVO pageVO) throws Exception;

    /**
     * 查询一个营地信息
     * @param cId
     * @return
     * @throws Exception
     */
    CampDto selectCampByCid(Integer cId) throws Exception;

    /**
     * 更新营地信息
     * @param campParam
     * @throws Exception
     */
    void updateCamp(CampParam campParam) throws Exception;

    /**
     * 下架营地
     * @param cId
     * @throws Exception
     */
    void deleteCampByCid(Integer cId) throws Exception;
}
