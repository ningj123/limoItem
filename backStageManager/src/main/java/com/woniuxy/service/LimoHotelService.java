package com.woniuxy.service;

import com.woniuxy.doman.LimoHotel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.param.AppParam;
import com.woniuxy.param.DetailParam;
import com.woniuxy.param.SleepParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
public interface LimoHotelService extends IService<LimoHotel> {
    /**
     * @Author zhuyuli
     * @Description //根据条件查询预约信息
     * @Date 2020/11/25 14:50
     * @Param [detail]
     * @return java.util.List<?>
     **/
    List<?> queryHotel(DetailParam detail)throws Exception;

    void insertHotel(SleepParam sleepParam)throws Exception;

    void insertHoteldetail(AppParam param)throws Exception;
    //查询使用情况
    List queryWork(Integer hid, Integer status)throws Exception;

    void outHotel(Integer apid, Integer hid)throws Exception;
}
