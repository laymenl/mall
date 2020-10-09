package com.cskaoyan.controller.wx.wxTopicController;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.wxvo.TopicDetailVO;
import com.cskaoyan.bean.wxvo.TopicListVO;
import com.cskaoyan.promoteModule.topicManage.bean.Topic;
import com.cskaoyan.promoteModule.topicManage.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx/topic")
public class WxTopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping("list")
    public BaseRespVo list(Integer page ,Integer size) {
        TopicListVO topicListVO = topicService.queryWxTopicList(page , size);
        return BaseRespVo.ok(topicListVO);
    }

    @RequestMapping("detail")
    public BaseRespVo detail(Integer id) {
        TopicDetailVO topicDetailVO = topicService.queryTopicDetail(id);
        return BaseRespVo.ok(topicDetailVO);
    }

    @RequestMapping("related")
    public BaseRespVo related(Integer id) {
        List<Topic> list = topicService.queryTopicRelated(id);
        return BaseRespVo.ok(list);
    }
}
