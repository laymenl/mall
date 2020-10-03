package com.cskaoyan.mapper;

import com.cskaoyan.bean.GoodsPart.Attribute;
import com.cskaoyan.bean.GoodsPart.AttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeMapper {
    long countByExample(AttributeExample example);

    int deleteByExample(AttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    List<Attribute> selectByExample(AttributeExample example);

    Attribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attribute record, @Param("example") AttributeExample example);

    int updateByExample(@Param("record") Attribute record, @Param("example") AttributeExample example);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKey(Attribute record);

    int insertAttributes(@Param("attributes") List<Attribute> attributes, @Param("goodsId") Integer goodsId);
}