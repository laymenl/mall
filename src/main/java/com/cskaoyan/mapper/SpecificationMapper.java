package com.cskaoyan.mapper;

import com.cskaoyan.bean.GoodsPart.Specification;
import com.cskaoyan.bean.GoodsPart.SpecificationExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecificationMapper {
    long countByExample(SpecificationExample example);

    int deleteByExample(SpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    List<Specification> selectByExample(SpecificationExample example);

    Specification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByExample(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);

    int insertSpecifications(@Param("specifications") List<Specification> specifications, @Param("goodsId") Integer goodsId);

    void setDeletedTrueByGoodsId(@Param("goodsId") Integer goodsId, @Param("updateTime") Date updateTime);
}