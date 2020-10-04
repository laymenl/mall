package com.cskaoyan.service.impl.shopImpl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.shop.keyword.Keyword;
import com.cskaoyan.bean.shop.keyword.KeywordExample;
import com.cskaoyan.mapper.shopMapper.KeywordMapper4Shop;
import com.cskaoyan.service.shopService.KeywordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    KeywordMapper4Shop keywordMapper4Shop;

    @Override
    public ListBean list(String keyword, String url, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);

        KeywordExample keywordExample = new KeywordExample();
        KeywordExample.Criteria criteria = keywordExample.createCriteria();
        if (keyword != null && keyword != ""){
            criteria.andKeywordLike("%" + keyword + "%");
        }
        if (url != null && keyword != ""){
            criteria.andUrlLike("%" + url + "%");
        }

        keywordExample.setOrderByClause(sort + " " + order);
        List<Keyword> keywords = keywordMapper4Shop.selectByExample(keywordExample);

        PageInfo pageInfo = new PageInfo(keywords);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(keywords);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    @Transactional
    public Keyword create(Keyword keyword) {
        keyword.setAddTime(new Date());
        keyword.setUpdateTime(new Date());
        keywordMapper4Shop.insertSelective(keyword);
        int id = keywordMapper4Shop.selectLastId();
        Keyword result = keywordMapper4Shop.selectByPrimaryKey(id);
        return result;
    }

    @Override
    @Transactional
    public Keyword update(Keyword keyword) {
        keyword.setUpdateTime(new Date());
        KeywordExample keywordExample = new KeywordExample();
        keywordExample.createCriteria().andIdEqualTo(keyword.getId());

        keywordMapper4Shop.updateByExampleSelective(keyword,keywordExample);

        return keywordMapper4Shop.selectByPrimaryKey(keyword.getId());
    }

    @Override
    public void delete(Keyword keyword) {
        keywordMapper4Shop.deleteByPrimaryKey(keyword.getId());
    }
}
