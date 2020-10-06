package com.cskaoyan.service.wx;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.bean.wxvo.LoginVO;
import com.cskaoyan.bean.wxvo.UserInfoVO;
import com.cskaoyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserMapper userMapper;

    @Override
    public LoginVO login(String tokenId, User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        String avatarUrl = users.size() > 0 ? users.get(0).getAvatar() : null;
        UserInfoVO userInfoVO = new UserInfoVO(user.getUsername(), avatarUrl);
        LoginVO loginVO = new LoginVO(userInfoVO, new Date(), tokenId);
        return loginVO;
    }
}
