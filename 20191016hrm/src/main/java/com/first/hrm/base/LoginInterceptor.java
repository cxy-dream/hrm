package com.first.hrm.base;

import com.first.hrm.bean.User;
import com.first.hrm.constant.WebConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(WebConstant.SESSION_USER);
        //如果session中user不为空说明用户已经登录，如果不存在说明用户还没有登录
        //如果用户没有登录就拦截，不让程序继续往下执行
        //如果用户已经登录那么允许用户请求直达目的地
        if(user !=null){
            // http://localhost:8088/main
            return true;
        }
        response.sendRedirect("/tologin");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
