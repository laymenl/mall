package com.cskaoyan.mapper;

import com.cskaoyan.bean.OrderPart.Order;
import com.cskaoyan.bean.OrderPart.OrderExample;
import com.cskaoyan.bean.wxvo.OrderInfoVO;
import com.cskaoyan.bean.wxvo.WxOrderListData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<WxOrderListData> selectWxOrderListDataByUserId(@Param("id")Integer userID, @Param("orderStatus")Integer showType);

    OrderInfoVO selectOrderInfoByOrderId(@Param("orderId")Integer orderId);
}