package com.cskaoyan.mapper.promoteModule;

import com.cskaoyan.promoteModule.couponManage.bean.CouponUser;
import com.cskaoyan.promoteModule.couponManage.bean.CouponUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponUserMapper {
    long countByExample(CouponUserExample example);

    int deleteByExample(CouponUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponUser record);

    int insertSelective(CouponUser record);

    List<CouponUser> selectByExample(CouponUserExample example);

    CouponUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponUser record, @Param("example") CouponUserExample example);

    int updateByExample(@Param("record") CouponUser record, @Param("example") CouponUserExample example);

    int updateByPrimaryKeySelective(CouponUser record);

    int updateByPrimaryKey(CouponUser record);

    Integer getAvailableCouponLength(@Param("userId") Integer userId);
}