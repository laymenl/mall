package com.cskaoyan.mapper;

import com.cskaoyan.bean.footprint.UserFootPrint;
import com.cskaoyan.bean.footprint.UserFootPrintExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFootPrintMapper {
    long countByExample(UserFootPrintExample example);

    int deleteByExample(UserFootPrintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFootPrint record);

    int insertSelective(UserFootPrint record);

    List<UserFootPrint> selectByExample(UserFootPrintExample example);

    UserFootPrint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFootPrint record, @Param("example") UserFootPrintExample example);

    int updateByExample(@Param("record") UserFootPrint record, @Param("example") UserFootPrintExample example);

    int updateByPrimaryKeySelective(UserFootPrint record);

    int updateByPrimaryKey(UserFootPrint record);
}