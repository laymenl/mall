package com.cskaoyan.mapper;

import com.cskaoyan.bean.GoodsPart.Product;
import com.cskaoyan.bean.GoodsPart.ProductExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int insertProducts(@Param("products") List<Product> products, @Param("goodsId") Integer goodsId);

    void setDeletedTrueByGoodsId(@Param("goodsId") Integer goodsId, @Param("updateTime") Date updateTime);
}