package com.cskaoyan.mapper;

import com.cskaoyan.bean.collect.UserCollect;
import com.cskaoyan.bean.collect.UserCollectExample;
import com.cskaoyan.bean.wxvo.CollectListBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCollectMapper {
    long countByExample(UserCollectExample example);

    int deleteByExample(UserCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCollect record);

    int insertSelective(UserCollect record);

    List<UserCollect> selectByExample(UserCollectExample example);

    UserCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCollect record, @Param("example") UserCollectExample example);

    int updateByExample(@Param("record") UserCollect record, @Param("example") UserCollectExample example);

    int updateByPrimaryKeySelective(UserCollect record);

    int updateByPrimaryKey(UserCollect record);

    List<CollectListBean> queryWxCollectListBean(Integer type);

    void deleteCollection(@Param("type") Byte type, @Param("valueid") Integer valueid, Integer id);

    void addCollection(UserCollect userCollect);

    void addCollection2(Byte type, Integer valueid, Integer id);
}