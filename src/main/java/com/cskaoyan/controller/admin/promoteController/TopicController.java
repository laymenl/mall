package com.cskaoyan.controller.admin.promoteController;


import com.cskaoyan.promoteModule.topicManage.bean.BaseRespVo;
import com.cskaoyan.promoteModule.topicManage.bean.ListBean;
import com.cskaoyan.promoteModule.topicManage.bean.Topic;
import com.cskaoyan.promoteModule.topicManage.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    /*
        参数 page=1&limit=20&sort=add_time&order=desc
    * */
    @RequestMapping("list")
    public BaseRespVo list(Integer page, Integer limit, String sort, String order) {
        ListBean listBean = topicService.queryTopicListBean(page, limit, sort, order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("create")
    public BaseRespVo create(@RequestBody Topic topic) {
        Topic topicInfo= topicService.create(topic);
        return BaseRespVo.ok(topicInfo);
    }


    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Topic topic){
        Topic topicInfo = topicService.update(topic);
        return BaseRespVo.ok(topicInfo);
    }


    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Topic topic){
        int status = topicService.delete(topic);
        return status == 1? BaseRespVo.ok(): BaseRespVo.fail("delete error");
    }
}

