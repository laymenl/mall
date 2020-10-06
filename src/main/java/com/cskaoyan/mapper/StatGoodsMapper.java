package com.cskaoyan.mapper;

import com.cskaoyan.bean.stat.StatGoods;
import com.cskaoyan.bean.stat.StatGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatGoodsMapper {
    long countByExample(StatGoodsExample example);

    int deleteByExample(StatGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatGoods record);

    int insertSelective(StatGoods record);

    List<StatGoods> selectByExample(StatGoodsExample example);

    StatGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatGoods record, @Param("example") StatGoodsExample example);

    int updateByExample(@Param("record") StatGoods record, @Param("example") StatGoodsExample example);

    int updateByPrimaryKeySelective(StatGoods record);

    int updateByPrimaryKey(StatGoods record);

    long countDistinctProducts(StatGoodsExample statGoodsExample);
}