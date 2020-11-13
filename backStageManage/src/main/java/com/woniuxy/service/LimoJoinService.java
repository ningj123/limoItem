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
 * @author wuyanzu
 * @since 2020-11-12
 */
public interface LimoJoinService extends IService<LimoJoin> {
    /**
     * 查询加盟信息
     * @param joinParam
     * @return
     * @throws Exception
     */
    public Page<LimoJoin> selectJion(JoinParam joinParam)throws Exception;

    /**
     * 根据加盟编号修改加盟状态
     * @param joinParam
     * @throws Exception
     */
    public void updateStatus(JoinParam joinParam)throws Exception;

}
