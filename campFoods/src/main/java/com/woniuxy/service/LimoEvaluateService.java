package com.woniuxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoEvaluate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.EvaluateDto;
import com.woniuxy.param.EvaluateParam;
import org.apache.velocity.runtime.directive.Evaluate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
public interface LimoEvaluateService extends IService<LimoEvaluate> {
    /**
     * 查询评价信息
     * @param evaluateParam
     * @return
     * @throws Exception
     */
    public Page<EvaluateDto> selectEvaluate(EvaluateParam evaluateParam)throws Exception;

    /**
     * 新增评价信息
     * @param evaluateParam
     * @throws Exception
     */
    public void insertEvaluate(EvaluateParam evaluateParam)throws Exception;

}
