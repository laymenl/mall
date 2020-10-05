package com.cskaoyan.mapper;

import com.cskaoyan.bean.stat.StatUser;
import com.cskaoyan.bean.stat.StatUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatUserMapper {
    long countByExample(StatUserExample example);

    int deleteByExample(StatUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatUser record);

    int insertSelective(StatUser record);

    List<StatUser> selectByExample(StatUserExample example);

    StatUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatUser record, @Param("example") StatUserExample example);

    int updateByExample(@Param("record") StatUser record, @Param("example") StatUserExample example);

    int updateByPrimaryKeySelective(StatUser record);

    int updateByPrimaryKey(StatUser record);
}