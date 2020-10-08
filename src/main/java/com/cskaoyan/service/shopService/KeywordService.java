package com.cskaoyan.service.shopService;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.keyword.Keyword;
import com.cskaoyan.bean.wxvo.SerachIndexVO;

import java.util.List;

public interface KeywordService {
    ListBean list(String keyword, String url, Integer page, Integer limit, String sort, String order);

    Keyword create(Keyword keyword);

    Keyword update(Keyword keyword);

    void delete(Keyword keyword);

    SerachIndexVO index();

    List<String> helper(String keyword);

    void clearHistory();
}
