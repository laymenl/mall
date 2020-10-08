package com.cskaoyan.mapper;

import com.cskaoyan.bean.UserAddress;
import com.cskaoyan.bean.UserAddressExample;
import com.cskaoyan.bean.wxvo.UserAddressDetailVO;
import com.cskaoyan.bean.wxvo.UserAddressVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAddressMapper {
    long countByExample(UserAddressExample example);

    int deleteByExample(UserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExample(UserAddressExample example);

    UserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    List<UserAddressDetailVO> queryUserAddressDeatil(Integer id);

    List<UserAddressVO> selectUserAddress(Integer id);
}