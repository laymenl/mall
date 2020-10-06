package com.cskaoyan.shiro;

import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class CustomSessionManager extends DefaultWebSessionManager {

    @Override
    public Serializable getSessionId(ServletRequest srerequest, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) srerequest;
        String sessionId = request.getHeader("X-cskaoyan-mall-Admin-Token");
        if(sessionId != null && !sessionId.isEmpty()){
            return sessionId;
        }
        return super.getSessionId(request, response);
    }

}
