package com.cskaoyan.promoteModule.topicManage.service;

import com.cskaoyan.promoteModule.topicManage.bean.ListBean;
import com.cskaoyan.promoteModule.topicManage.bean.Topic;

public interface TopicService {
    ListBean queryTopicListBean(Integer page, Integer limit, String sort, String order);

    Topic create(Topic topic);

    Topic update(Topic topic);

    int delete(Topic topic);
}
