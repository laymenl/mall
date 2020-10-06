package com.cskaoyan.service.wx;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.wxvo.LoginVO;

public interface AuthService {
    LoginVO login(String tokenId, User user);
}
