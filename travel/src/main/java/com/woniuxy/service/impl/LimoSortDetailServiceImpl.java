package com.woniuxy.service.impl;

import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.mapper.LimoSortDetailMapper;
import com.woniuxy.service.LimoSortDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-07
 */
@Service
public class LimoSortDetailServiceImpl extends ServiceImpl<LimoSortDetailMapper, LimoSortDetail> implements LimoSortDetailService {
    @Resource
    private LimoSortDetailMapper  limoSortDetailMapper;
}
