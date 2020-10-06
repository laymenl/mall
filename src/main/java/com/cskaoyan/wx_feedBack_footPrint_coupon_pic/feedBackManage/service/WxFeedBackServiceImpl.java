package com.cskaoyan.wx_feedBack_footPrint_coupon_pic.feedBackManage.service;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.feedback.UserFeedback;
import com.cskaoyan.mapper.UserFeedbackMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.bean.wxvo.UserInfoVO;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class WxFeedBackServiceImpl implements WxFeedBackService{

    @Resource
    UserFeedbackMapper userFeedbackMapper;

    @Resource
    UserMapper userMapper;

    @SneakyThrows
    @Override
    public int submit(UserFeedback userFeedback) {

        Subject subject = SecurityUtils.getSubject();
        //String username = (String) subject.getPrincipals().getPrimaryPrincipal();

        String username = "test1";

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);

        userFeedback.setUserId(user.getId());
        userFeedback.setUsername(user.getUsername());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        Date updateTime = simpleDateFormat.parse(date);
        userFeedback.setAddTime(updateTime);
        userFeedback.setUpdateTime(updateTime);

        int submitStatus = userFeedbackMapper.insert(userFeedback);
        return submitStatus;
    }
}
