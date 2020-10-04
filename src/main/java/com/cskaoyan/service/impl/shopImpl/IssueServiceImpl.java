package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.issue.Issue;
import com.cskaoyan.bean.shop.issue.IssueExample;
import com.cskaoyan.mapper.shopMapper.IssueMapper4Shop;
import com.cskaoyan.service.shopService.IssueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper4Shop issueMapper4Shop;

    @Override
    public ListBean list(String question, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);

        IssueExample issueExample = new IssueExample();
        IssueExample.Criteria criteria = issueExample.createCriteria();

        if (question != null && question != ""){
            criteria.andQuestionLike("%" + question + "%");
        }

        issueExample.setOrderByClause(sort + " " + order);
        List<Issue> issues = issueMapper4Shop.selectByExample(issueExample);

        PageInfo pageInfo = new PageInfo(issues);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(issues);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    @Transactional
    public Issue create(Issue issue) {
        issue.setAddTime(new Date());
        issue.setUpdateTime(new Date());
        issueMapper4Shop.insertSelective(issue);

        int id = issueMapper4Shop.selectLastId();
        Issue result = issueMapper4Shop.selectByPrimaryKey(id);
        return result;
    }

    @Override
    @Transactional
    public Issue update(Issue issue) {
        issue.setUpdateTime(new Date());
        IssueExample issueExample = new IssueExample();
        issueExample.createCriteria().andIdEqualTo(issue.getId());

        issueMapper4Shop.updateByExampleSelective(issue,issueExample);

        return issueMapper4Shop.selectByPrimaryKey(issue.getId());
    }

    @Override
    @Transactional
    public void delete(Issue issue) {
        issueMapper4Shop.deleteByPrimaryKey(issue.getId());
    }

}
