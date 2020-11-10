package com.woniuxy.mapper;

import com.woniuxy.domain.LimoOrder;
import com.woniuxy.domain.LimoOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LimoOrderMapper {
    long countByExample(LimoOrderExample example);

    int deleteByExample(LimoOrderExample example);

    int deleteByPrimaryKey(Integer oId);

    int insert(LimoOrder record);

    int insertSelective(LimoOrder record);

    List<LimoOrder> selectByExample(LimoOrderExample example);

    LimoOrder selectByPrimaryKey(Integer oId);

    int updateByExampleSelective(@Param("record") LimoOrder record, @Param("example") LimoOrderExample example);

    int updateByExample(@Param("record") LimoOrder record, @Param("example") LimoOrderExample example);

    int updateByPrimaryKeySelective(LimoOrder record);

    int updateByPrimaryKey(LimoOrder record);
}