package com.woniuxy.service;

import com.woniuxy.doman.LimoSecSpot;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.dto.LimoSecSpotDto;
import com.woniuxy.param.PointParam;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortParam1;
import com.woniuxy.param.SortTypeParam;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-10
 */
public interface LimoSecSpotService extends IService<LimoSecSpot> {
    /**
     * @Author zhuyuli
     * @Description 条件查询周边景点
     * @Date 2020/11/11 10:53
     * @Param [param]
     * @return java.lang.Object
     **/
    Object queryByParam(SortTypeParam param)throws  Exception;

    void insertSport(SortParam1 param) throws  Exception;

    Long redisGeoAdd()throws Exception;

    List geoNearByPlace(PointParam param)throws Exception;

    LimoSecSpotDto queryById(Integer id)throws Exception;

    void updateSport(SortParam param) throws Exception;
}
