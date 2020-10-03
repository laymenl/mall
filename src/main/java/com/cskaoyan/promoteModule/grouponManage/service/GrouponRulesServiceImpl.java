package com.cskaoyan.promoteModule.grouponManage.service;

import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.GoodsExample;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.promoteModule.GrouponRulesMapper;
import com.cskaoyan.mapper.promoteModule.listRecord.GrouponMapper;
import com.cskaoyan.promoteModule.grouponManage.bean.GrouponRules;
import com.cskaoyan.promoteModule.grouponManage.bean.GrouponRulesExample;
import com.cskaoyan.promoteModule.grouponManage.bean.ListBean;
import com.cskaoyan.promoteModule.grouponManage.bean.listRecord.Groupon;
import com.cskaoyan.promoteModule.grouponManage.bean.listRecord.GrouponExample;
import com.cskaoyan.promoteModule.grouponManage.bean.listRecord.ListRecordVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GrouponRulesServiceImpl implements GrouponRulesService {

    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public ListBean queryGrouponRulesListBean(Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page, limit);

        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria();

        grouponRulesExample.setOrderByClause(sort + " " + order);
        List<GrouponRules> grouponRuless = grouponRulesMapper.selectByExample(grouponRulesExample);
        for (GrouponRules grouponRulesUser : grouponRuless) {
            System.out.println("查询到的grouponRules：" + grouponRuless);
        }

        PageInfo pageInfo = new PageInfo(grouponRuless);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(grouponRuless);
        listBean.setTotal(total);

        return listBean;
    }

    @Override
    public ListBean queryRecordListBean(Integer page, Integer limit, String sort, String order) {
        List recordList = new ArrayList();

        PageHelper.startPage(page, limit);

        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria();

        grouponRulesExample.setOrderByClause(sort + " " + order);
        List<GrouponRules> grouponRuless = grouponRulesMapper.selectByExample(grouponRulesExample);

        for (GrouponRules grouponRules : grouponRuless) {
            ListRecordVo listRecordVo = new ListRecordVo();

            listRecordVo.setRules(grouponRules);

            GrouponExample grouponExample = new GrouponExample();
            grouponExample.createCriteria().andRulesIdEqualTo(grouponRules.getId());
            Groupon groupon = grouponMapper.selectByExample(grouponExample).get(0);
            listRecordVo.setGroupon(groupon);

            GoodsExample goodsExample = new GoodsExample();
            goodsExample.createCriteria().andIdEqualTo(grouponRules.getGoodsId());
            Goods goods = goodsMapper.selectByExample(goodsExample).get(0);
            listRecordVo.setGoods(goods);

            recordList.add(listRecordVo);
        }


        PageInfo pageInfo = new PageInfo(grouponRuless);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(recordList);
        listBean.setTotal(total);

        return listBean;
    }

    @SneakyThrows
    @Override
    public GrouponRules create(GrouponRules grouponRules) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        Date addTime = updateTime;

        grouponRules.setAddTime(addTime);
        grouponRules.setUpdateTime(updateTime);

        grouponRulesMapper.insert(grouponRules);

        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria().andIdEqualTo(grouponRules.getId()).andAddTimeEqualTo(grouponRules.getAddTime());

        List<GrouponRules> grouponRuless = grouponRulesMapper.selectByExample(grouponRulesExample);
        return grouponRuless.get(0);
    }

    @SneakyThrows
    @Override
    public GrouponRules update(GrouponRules grouponRules) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        grouponRules.setUpdateTime(updateTime);

        grouponRulesMapper.updateByPrimaryKeySelective(grouponRules);
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria().andIdEqualTo(grouponRules.getId());
        List<GrouponRules> grouponRuless = grouponRulesMapper.selectByExample(grouponRulesExample);
        return grouponRuless.get(0);
    }

    @Override
    public int delete(GrouponRules grouponRules) {
        int status = grouponRulesMapper.deleteByPrimaryKey(grouponRules.getId());
        return status;
    }
}
