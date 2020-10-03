package com.cskaoyan.promoteModule.topicManage.service;

import com.cskaoyan.mapper.promoteModule.TopicMapper;
import com.cskaoyan.promoteModule.topicManage.bean.ListBean;
import com.cskaoyan.promoteModule.topicManage.bean.Topic;
import com.cskaoyan.promoteModule.topicManage.bean.TopicExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public ListBean queryTopicListBean(Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page, limit);

        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria();

        topicExample.setOrderByClause(sort + " " + order);
        List<Topic> topics = topicMapper.selectByExample(topicExample);
        for (Topic topicUser : topics) {
            System.out.println("查询到的topic：" + topics);
        }

        PageInfo pageInfo = new PageInfo(topics);
        long total = pageInfo.getTotal();

        ListBean listBean = new ListBean();
        listBean.setItems(topics);
        listBean.setTotal(total);

        return listBean;
    }


    @SneakyThrows
    @Override
    public Topic create(Topic topic) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        Date addTime = updateTime;

        topic.setAddTime(addTime);
        topic.setUpdateTime(updateTime);

        topicMapper.insert(topic);

        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andPicUrlEqualTo(topic.getPicUrl()).andAddTimeEqualTo(topic.getAddTime());

        List<Topic> topics = topicMapper.selectByExample(topicExample);
        return topics.get(0);
    }

    @SneakyThrows
    @Override
    public Topic update(Topic topic) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        topic.setUpdateTime(updateTime);

        topicMapper.updateByPrimaryKeySelective(topic);
        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andIdEqualTo(topic.getId());
        List<Topic> topics = topicMapper.selectByExample(topicExample);
        return topics.get(0);
    }

    @Override
    public int delete(Topic topic) {
        int status = topicMapper.deleteByPrimaryKey(topic.getId());
        return status;
    }
}
