package com.cskaoyan.service.shopService;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.issue.Issue;

public interface IssueService {
    ListBean list(String question, Integer page, Integer limit, String sort, String order);

    Issue create(Issue issue);

    Issue update(Issue issue);

    void delete(Issue issue);
}
