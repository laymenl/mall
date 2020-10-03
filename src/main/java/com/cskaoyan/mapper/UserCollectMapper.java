package com.cskaoyan.mapper;

import com.cskaoyan.bean.collect.UserCollect;
import com.cskaoyan.bean.collect.UserCollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCollectMapper {
    long countByExample(UserCollectExample example);

    int deleteByExample(UserCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCollect record);

    int insertSelective(UserCollect record);

    List<UserCollect> selectByExample(UserCollectExample example);

    UserCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCollect record, @Param("example") UserCollectExample example);

    int updateByExample(@Param("record") UserCollect record, @Param("example") UserCollectExample example);

    int updateByPrimaryKeySelective(UserCollect record);

    int updateByPrimaryKey(UserCollect record);
}