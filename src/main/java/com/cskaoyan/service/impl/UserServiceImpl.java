package com.cskaoyan.service.impl;
import com.cskaoyan.bean.*;
import com.cskaoyan.bean.collect.CollectListBean;
import com.cskaoyan.bean.collect.UserCollect;
import com.cskaoyan.bean.collect.UserCollectExample;
import com.cskaoyan.bean.feedback.FeedBackListBean;
import com.cskaoyan.bean.feedback.UserFeedback;
import com.cskaoyan.bean.feedback.UserFeedbackExample;
import com.cskaoyan.bean.footprint.FootPrintListBean;
import com.cskaoyan.bean.footprint.UserFootPrint;
import com.cskaoyan.bean.footprint.UserFootPrintExample;
import com.cskaoyan.bean.history.HistoryListBean;
import com.cskaoyan.bean.history.UserSearchHistory;
import com.cskaoyan.bean.history.UserSearchHistoryExample;
import com.cskaoyan.bean.wxvo.CollectListVO;
import com.cskaoyan.bean.wxvo.UserAddressDetailVO;
import com.cskaoyan.bean.wxvo.UserAddressVO;
import com.cskaoyan.mapper.*;
import com.cskaoyan.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserAddressMapper userAddressMapper;
    @Autowired
    UserCollectMapper userCollectMapper;
    @Autowired
    UserFootPrintMapper userFootPrintMapper;
    @Autowired
    UserSearchHistoryMapper userSearchHistoryMapper;
    @Autowired
    UserFeedbackMapper userFeedbackMapper;

    @Override
    public ListBean queryUserListBean(String username, String mobile, Integer page, Integer limit, String sort, String order) {
        //分页
        PageHelper.startPage(page,limit);
        //example是提供条件的
        UserExample userExample = new UserExample();
        //and + 列名 + 条件
        UserExample.Criteria criteria = userExample.createCriteria();
        if (username != null){
            criteria.andUsernameLike("%" + username + "%");
        }
        if (mobile != null){
            criteria.andMobileEqualTo(mobile);
        }
      //userExample.createCriteria().andUsernameLike("%"+username+"%").andMobileEqualTo(mobile);
        userExample.setOrderByClause(sort + " " + order);
        List<User> users = userMapper.selectByExample(userExample);

        //分页信息
        PageInfo pageInfo = new PageInfo(users);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(users);
        //listBean.setTotal(users.size());
        listBean.setTotal(total);

        return listBean;
    }

    @Override
    public AddressListBean queryUserAddressListBean(String userId, String name, Integer page, Integer limit, String sort, String order) {

        PageHelper.startPage(page,limit);
        UserAddressExample userAddressExample = new UserAddressExample();
        UserAddressExample.Criteria criteria = userAddressExample.createCriteria();

        if (userId!=null){
            criteria.andAddressEqualTo(userId);
        }
        if (name!=null){
            criteria.andAddressLike("%"+name+"%");
        }
        userAddressExample.setOrderByClause(sort+ " "+ order);
        List<UserAddress> userAddresses = userAddressMapper.selectByExample(userAddressExample);
        //
        PageInfo pageInfo = new PageInfo(userAddresses);
        long total = pageInfo.getTotal();
        AddressListBean addressListBean = new AddressListBean();
        addressListBean.setItems(userAddresses);
        addressListBean.setTotal(total);
        return addressListBean;
    }

    @Override
    public CollectListBean queryUserCollectListBean(Integer userId, Integer valueId, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        UserCollectExample userCollectExample = new UserCollectExample();
        UserCollectExample.Criteria criteria = userCollectExample.createCriteria();

        if (userId!=null){
            criteria.andAddTimeEqualTo(userId);
        }

        if (valueId!=null){
            criteria.andAddTimeEqualTo(valueId);
        }
        userCollectExample.setOrderByClause(sort+" " +order);
        List<UserCollect> userCollects = userCollectMapper.selectByExample(userCollectExample);

        PageInfo pageInfo = new PageInfo(userCollects);
        long total = pageInfo.getTotal();
        CollectListBean collectListBean = new CollectListBean();
        collectListBean.setItems(userCollects);
        collectListBean.setTotal(total);

        return collectListBean;
    }

    @Override
    public FootPrintListBean queryUserFootPrintListBean(Integer userId, Integer goodId, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        UserFootPrintExample userFootPrintExample = new UserFootPrintExample();
        UserFootPrintExample.Criteria criteria = userFootPrintExample.createCriteria();

        if (userId!=null){
            criteria.andUserIdEqualTo(userId);
        }

        if (goodId!=null){
            criteria.andGoodsIdEqualTo(goodId);
        }
        userFootPrintExample.setOrderByClause(sort+" "+order);
        List<UserFootPrint> userFootPrints = userFootPrintMapper.selectByExample(userFootPrintExample);
        PageInfo pageInfo = new PageInfo(userFootPrints);
        long total = pageInfo.getTotal();

        FootPrintListBean footPrintListBean = new FootPrintListBean();
        footPrintListBean.setItems(userFootPrints);
        footPrintListBean.setTotal(total);

        return footPrintListBean;
    }

    @Override
    public HistoryListBean queryUserSearchHistoryListBean(Integer userId, String keyword, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        UserSearchHistoryExample userSearchHistoryExample = new UserSearchHistoryExample();
        UserSearchHistoryExample.Criteria criteria = userSearchHistoryExample.createCriteria();

        if (userId!=null){
            criteria.andUserIdEqualTo(userId);
        }
        if (keyword!=null){
            criteria.andKeywordLike("%"+keyword+"%");
        }
        userSearchHistoryExample.setOrderByClause(sort+ " "+ order);
        List<UserSearchHistory> userSearchHistories = userSearchHistoryMapper.selectByExample(userSearchHistoryExample);
        PageInfo pageInfo = new PageInfo(userSearchHistories);
        long total=pageInfo.getTotal();

        HistoryListBean historyListBean = new HistoryListBean();
        historyListBean.setItems(userSearchHistories);
        historyListBean.setTotal(total);
        return  historyListBean;

    }

    @Override
    public FeedBackListBean queryUserFeedBackListBean(String username, Integer id, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        UserFeedbackExample userFeedbackExample = new UserFeedbackExample();
        UserFeedbackExample.Criteria criteria = userFeedbackExample.createCriteria();
        if (username!=null){
            criteria.andUsernameLike("%"+username+"%");
        }
        if (id!=null){
            criteria.andIdEqualTo(id);
        }
        userFeedbackExample.setOrderByClause(sort+""+order);
        List<UserFeedback> userFeedbacks = userFeedbackMapper.selectByExample(userFeedbackExample);
        PageInfo pageInfo = new PageInfo(userFeedbacks);
        long total=pageInfo.getTotal();

        FeedBackListBean feedBackListBean = new FeedBackListBean();
        feedBackListBean.setItems(userFeedbacks);
        feedBackListBean.setTotal(total);
        return feedBackListBean;
    }

    @Override
    public CollectListVO queryWxCollectListBean(Integer type, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        Integer id = users.get(0).getId();
        List<com.cskaoyan.bean.wxvo.CollectListBean> collectListBeans = userCollectMapper.queryWxCollectListBean(type,id);
        PageInfo pageInfo = new PageInfo(collectListBeans);
        long total = pageInfo.getTotal();
        CollectListVO collectListVO = new CollectListVO();
        collectListVO.setCollectList(collectListBeans);
        collectListVO.setTotalPages(total);
        return collectListVO;
    }

    @SneakyThrows
    @Override
    public String addOrDeleteCollection(UserCollect userCollect) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        Integer id = users.get(0).getId();
        UserCollectExample userCollectExample = new UserCollectExample();
        UserCollectExample.Criteria criteria = userCollectExample.createCriteria();
        criteria.andValueIdEqualTo(userCollect.getValueId()).andUserIdEqualTo(id);
        List<UserCollect> userCollects = userCollectMapper.selectByExample(userCollectExample);
        if(userCollects.size()==0){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            String date = simpleDateFormat.format(new Date());
            Date dateTime = simpleDateFormat.parse(date);
            userCollect.setAddTime(dateTime);
            userCollect.setDeleted(false);
            userCollect.setUpdateTime(dateTime);
            userCollect.setUserId(id);
            userCollectMapper.addCollection(userCollect);
            return "add";
        }else{
            if(userCollects.get(0).getDeleted().equals(Boolean.TRUE)){
                userCollectMapper.addCollection2(userCollect.getType(), userCollect.getValueId(), id);
                return "add";
            } else {
                userCollectMapper.deleteCollection(userCollect.getType(), userCollect.getValueId(), id);
                return "delete";
            }
        }

    }

    @Override
    public List<UserAddressVO> queryUserAddress() {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        Integer id = users.get(0).getId();
        List<UserAddressVO> userAddresses = userAddressMapper.selectUserAddress(id);
        return userAddresses;
    }

    @Override
    public UserAddressDetailVO queryUserAddressDetail(Integer id) {
        List<UserAddressDetailVO> userAddresses = userAddressMapper.queryUserAddressDeatil(id);
        UserAddressDetailVO userAddressDetailVO = userAddresses.get(0);
        return userAddressDetailVO;
    }

    @Override
    public Integer saveUserAddress(UserAddress userAddress) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        Integer userId = users.get(0).getId();
        UserAddressExample userAddressExample = new UserAddressExample();
        UserAddressExample.Criteria criteria = userAddressExample.createCriteria();
        if(userAddress.getId()==0){
            userAddress.setUserId(userId);
            userAddressMapper.insertSelective(userAddress);
        }else {
            criteria.andUserIdEqualTo(userId).andIdEqualTo(userAddress.getId());
            userAddress.setUserId(userId);
            userAddressMapper.updateByExampleSelective(userAddress, userAddressExample);
        }
        return userAddress.getId();
    }

    @Override
    public Integer deleteUserAddress(HashMap map) {
        Object id = map.get("id");
        int i = userAddressMapper.deleteByPrimaryKey((Integer) id) ;
        return i;
    }

}
