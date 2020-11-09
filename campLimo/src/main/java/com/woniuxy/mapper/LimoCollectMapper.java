package com.woniuxy.mapper;

import com.woniuxy.domain.LimoCollect;
import com.woniuxy.domain.LimoCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LimoCollectMapper {
    long countByExample(LimoCollectExample example);

    int deleteByExample(LimoCollectExample example);

    int deleteByPrimaryKey(Integer coId);

    int insert(LimoCollect record);

    int insertSelective(LimoCollect record);

    List<LimoCollect> selectByExample(LimoCollectExample example);

    LimoCollect selectByPrimaryKey(Integer coId);

    int updateByExampleSelective(@Param("record") LimoCollect record, @Param("example") LimoCollectExample example);

    int updateByExample(@Param("record") LimoCollect record, @Param("example") LimoCollectExample example);

    int updateByPrimaryKeySelective(LimoCollect record);

    int updateByPrimaryKey(LimoCollect record);
}