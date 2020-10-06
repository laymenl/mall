package com.cskaoyan.mapper;

import com.cskaoyan.bean.stat.StatOrder;
import com.cskaoyan.bean.stat.StatOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatOrderMapper {
    long countByExample(StatOrderExample example);

    long countDistinctId(StatOrderExample example);

    int deleteByExample(StatOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatOrder record);

    int insertSelective(StatOrder record);

    List<StatOrder> selectByExample(StatOrderExample example);

    StatOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatOrder record, @Param("example") StatOrderExample example);

    int updateByExample(@Param("record") StatOrder record, @Param("example") StatOrderExample example);

    int updateByPrimaryKeySelective(StatOrder record);

    int updateByPrimaryKey(StatOrder record);
}