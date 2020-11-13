package com.woniuxy.mapper;

import com.woniuxy.domain.LimoOrderDetail;
import com.woniuxy.domain.LimoOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LimoOrderDetailMapper {
    long countByExample(LimoOrderDetailExample example);

    int deleteByExample(LimoOrderDetailExample example);

    int deleteByPrimaryKey(Integer orId);

    int insert(LimoOrderDetail record);

    int insertSelective(LimoOrderDetail record);

    List<LimoOrderDetail> selectByExample(LimoOrderDetailExample example);

    LimoOrderDetail selectByPrimaryKey(Integer orId);

    int updateByExampleSelective(@Param("record") LimoOrderDetail record, @Param("example") LimoOrderDetailExample example);

    int updateByExample(@Param("record") LimoOrderDetail record, @Param("example") LimoOrderDetailExample example);

    int updateByPrimaryKeySelective(LimoOrderDetail record);

    int updateByPrimaryKey(LimoOrderDetail record);
}