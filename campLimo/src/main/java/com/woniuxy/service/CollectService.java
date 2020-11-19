package com.woniuxy.service;

import com.woniuxy.domain.LimoCollect;

/**
 * @ClassName CollectService
 * @Author shadow
 * @Date 2020/11/9 14:55
 * @Description TODO
 **/
public interface CollectService {
    /**
     * 新增收藏
     * @param cId
     * @param uId
     * @throws Exception
     */
    void insertCollect(Integer cId,Integer uId) throws Exception;

    /**
     * 查询该用户是否收藏了
     * @param uId
     * @return
     * @throws Exception
     */
    LimoCollect selectCollect(Integer cId,Integer uId) throws Exception;

    /**
     * 删除收藏
     * @param coId
     * @throws Exception
     */
    void deleteCollect(Integer coId) throws Exception;
}
