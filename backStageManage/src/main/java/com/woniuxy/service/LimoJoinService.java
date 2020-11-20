package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoJoin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.JoinParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shadow
 * @since 2020-11-13
 */
public interface LimoJoinService extends IService<LimoJoin> {
    /**
     * 查询加盟信息
     * @param
     * @return
     * @throws Exception
     */
    public Page<LimoJoin> selectJion(Integer pageNum,Integer pageSize)throws Exception;

    /**
     * 根据加盟编号修改加盟状态
     * @param
     * @throws Exception
     */
    public void updateStatus(Integer jId,Integer jStatus)throws Exception;

}
