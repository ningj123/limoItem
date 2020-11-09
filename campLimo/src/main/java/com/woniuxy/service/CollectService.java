package com.woniuxy.service;

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
}
