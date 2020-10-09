package com.cskaoyan.promoteModule.topicManage.service;

import com.cskaoyan.bean.wxvo.TopicDetailVO;
import com.cskaoyan.bean.wxvo.TopicListVO;
import com.cskaoyan.promoteModule.topicManage.bean.ListBean;
import com.cskaoyan.promoteModule.topicManage.bean.Topic;

import java.util.List;

public interface TopicService {
    ListBean queryTopicListBean(Integer page, Integer limit, String sort, String order);

    Topic create(Topic topic);

    Topic update(Topic topic);

    int delete(Topic topic);

    TopicListVO queryWxTopicList(Integer page ,Integer size);

    TopicDetailVO queryTopicDetail(Integer id);

    List<Topic> queryTopicRelated(Integer id);
}
