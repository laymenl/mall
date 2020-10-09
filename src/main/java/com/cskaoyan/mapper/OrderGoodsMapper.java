package com.cskaoyan.mapper;

import com.cskaoyan.bean.OrderPart.OrderGoods;
import com.cskaoyan.bean.OrderPart.OrderGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {
    long countByExample(OrderGoodsExample example);

    int deleteByExample(OrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    List<OrderGoods> selectByExample(OrderGoodsExample example);

    OrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
<<<<<<< HEAD
=======

    OrderGoods selectByOrderIdAndGoodsId(@Param("orderId")Integer orderId,@Param("goodsId") Integer goodsId);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
}