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

<<<<<<< HEAD
    List<CollectListBean> queryWxCollectListBean(Integer type,Integer id);
=======
    List<CollectListBean> queryWxCollectListBean(Integer type);
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678

    void deleteCollection(Byte type, Integer valueId,Integer id);

    void addCollection(UserCollect userCollect);

    void addCollection2(Byte type, Integer valueid, Integer id);
}