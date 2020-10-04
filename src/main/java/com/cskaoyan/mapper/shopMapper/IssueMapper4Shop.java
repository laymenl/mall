package com.cskaoyan.mapper.shopMapper;

import com.cskaoyan.bean.shop.issue.Issue;
import com.cskaoyan.bean.shop.issue.IssueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IssueMapper4Shop {
    long countByExample(IssueExample example);

    int deleteByExample(IssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    List<Issue> selectByExample(IssueExample example);

    Issue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByExample(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);

    int selectLastId();
}