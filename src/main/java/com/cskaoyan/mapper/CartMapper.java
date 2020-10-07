package com.cskaoyan.mapper;

import com.cskaoyan.bean.wxvo.cart.Cart;
import com.cskaoyan.bean.wxvo.cart.CartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    int getGoodsCount(@Param("userId") Integer userId);

    int getCheckedGoodsCount(@Param("userId") Integer userId);

    int getGoodsAmount(@Param("userId") Integer userId);

    int getCheckedGoodsAmount(@Param("userId") Integer userId);
}