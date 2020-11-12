package com.woniuxy.mapper;

import com.woniuxy.domain.LimoJoin;
import com.woniuxy.domain.LimoJoinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LimoJoinMapper {
    long countByExample(LimoJoinExample example);

    int deleteByExample(LimoJoinExample example);

    int deleteByPrimaryKey(Integer jId);

    int insert(LimoJoin record);

    int insertSelective(LimoJoin record);

    List<LimoJoin> selectByExample(LimoJoinExample example);

    LimoJoin selectByPrimaryKey(Integer jId);

    int updateByExampleSelective(@Param("record") LimoJoin record, @Param("example") LimoJoinExample example);

    int updateByExample(@Param("record") LimoJoin record, @Param("example") LimoJoinExample example);

    int updateByPrimaryKeySelective(LimoJoin record);

    int updateByPrimaryKey(LimoJoin record);
}