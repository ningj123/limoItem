package com.woniuxy.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.domain.LimoCamp;
import com.woniuxy.dto.CampDto;
import com.woniuxy.vo.PageVO;

import java.util.List;

/**
 * @ClassName CampService
 * @Author shadow
 * @Date 2020/11/9 13:07
 * @Description TODO
 **/
public interface CampService {
    /**
     * 根据城市名查询该城市的营地
     * @param city
     * @param pageVO
     * @return
     * @throws Exception
     */
    PageInfo<CampDto> selectCampsByCity(String city,String context, PageVO pageVO)throws Exception;

    /**
     * 根据营地id查询营地具体信息
     * @param id
     * @return
     * @throws Exception
     */
    CampDto selectCampById(Integer id) throws Exception;

    /**
     * selectCamps
     * @return
     * @throws Exception
     */
    List<CampDto> selectCamps() throws Exception;
}
