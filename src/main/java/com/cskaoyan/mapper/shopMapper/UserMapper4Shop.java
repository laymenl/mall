package com.cskaoyan.mapper.shopMapper;

import com.cskaoyan.bean.shop.order.User;
import com.cskaoyan.bean.shop.order.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper4Shop {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}