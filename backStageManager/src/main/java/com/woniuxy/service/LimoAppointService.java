package com.woniuxy.service;

import com.woniuxy.doman.LimoAppoint;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
public interface LimoAppointService extends IService<LimoAppoint> {

    List qurty(String startTime, String endtime)throws  Exception ;
}
