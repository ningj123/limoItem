package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.woniuxy.domain.LimoCamp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.*;
import com.woniuxy.param.CampParam;
import com.woniuxy.param.LimoActivityParam;
import com.woniuxy.param.LimoJoinParam;
import com.woniuxy.param.LimoParam;
import com.woniuxy.param.PageVO;

import java.util.List;

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

    /**
     * 查询该管理员下营地的所有房车或特色住宿列表
     * @param pType
     * @param mId
     * @param pageVO
     * @return
     * @throws Exception
     */
    PageInfo<LimosDto> selectLimos(Integer pType, Integer mId, PageVO pageVO) throws Exception;

    /**
     * 查询某个房车信息
     * @param pId
     * @return
     * @throws Exception
     */
    LimoDto selectLimoById(Integer pId) throws Exception;

    /**
     * 删除某个房车或特色住宿
     * @param pId
     * @throws Exception
     */
    void deleteLimoById(Integer pId) throws Exception;

    /**
     * 更新某个房车或特色住宿信息
     * @param limoParam
     * @throws Exception
     */
    void updateLimo(LimoParam limoParam) throws Exception;

    /**
     * 查询该管理员下营地内所有商品信息
     * @param pType
     * @param pageVO
     * @return
     * @throws Exception
     */
    PageInfo<LimosDto> selectProducts(Integer pType,Integer mId,PageVO pageVO) throws Exception;

    /**
     * 新增商品
     * @param limoParam
     * @throws Exception
     */
    void insertProduct(LimoParam limoParam) throws Exception;

    /**
     * 查询该营地管理员下的房车加盟申请
     * @param pageVO
     * @return
     * @throws Exception
     */
    PageInfo<LimoJoinsDto> selectLimoJoin(Integer mId, PageVO pageVO) throws Exception;

    /**
     * 是否同意房车加盟
     * @param limoJoinParam
     * @throws Exception
     */
    void updateJoin(LimoJoinParam limoJoinParam) throws Exception;

    /**
     * 查询该管理员所属营地的活动信息
     * @param aType
     * @param pageVO
     * @return
     * @throws Exception
     */
    PageInfo<LimoActivitiesDto> selectActivity(Integer aType,Integer mId,PageVO pageVO) throws Exception;

    /**
     * 查询某个活动信息
     * @param aId
     * @return
     * @throws Exception
     */
    LimoActivityDto selectActivityById(Integer aId) throws Exception;

    /**
     * 新增活动
     * @param limoActivityParam
     * @throws Exception
     */
    void insertActivity(LimoActivityParam limoActivityParam) throws Exception;

    /**
     * 删除活动
     * @param aId
     * @throws Exception
     */
    void deleteActivity(Integer aId) throws Exception;

    /**
     * 修改活动
     * @param limoActivityParam
     * @throws Exception
     */
    void updateActivity(LimoActivityParam limoActivityParam) throws Exception;
}
