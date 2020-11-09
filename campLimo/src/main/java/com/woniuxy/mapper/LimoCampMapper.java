package com.woniuxy.mapper;

import com.woniuxy.domain.LimoCamp;
import com.woniuxy.domain.LimoCampExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LimoCampMapper {
    long countByExample(LimoCampExample example);

    int deleteByExample(LimoCampExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(LimoCamp record);

    int insertSelective(LimoCamp record);

    List<LimoCamp> selectByExample(LimoCampExample example);

    LimoCamp selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") LimoCamp record, @Param("example") LimoCampExample example);

    int updateByExample(@Param("record") LimoCamp record, @Param("example") LimoCampExample example);

    int updateByPrimaryKeySelective(LimoCamp record);

    int updateByPrimaryKey(LimoCamp record);
}