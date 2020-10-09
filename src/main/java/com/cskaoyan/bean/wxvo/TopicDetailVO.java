package com.cskaoyan.bean.wxvo;

import com.cskaoyan.promoteModule.topicManage.bean.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TopicDetailVO {


        /**
         * topic : {"id":335,"title":"duck","subtitle":"duck","price":123,"readCount":"123k","picUrl":"http://182.92.235.201:8083/wx/storage/fetch/jp6hjvanmh6yvludcaa0.jpg","sortOrder":100,"goods":[],"addTime":"2020-10-07 16:02:01","updateTime":"2020-10-07 16:02:01","deleted":false,"content":"<p>快乐小黄鸭<\/p>"}
         * goods : []
         */
        private Topic topic;
        private String[] goods;
}
