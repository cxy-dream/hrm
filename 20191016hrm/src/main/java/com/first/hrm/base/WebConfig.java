package com.first.hrm.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //xml配置文件
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    //通过配置类把拦截器注册到InterceptorRegistry中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //配置拦截器的拦截规则
        String[] pathPatterns={"/**"}; //拦截哪些
        String[] excludePathPatterns={"/tologin","/css/**","/images/**","/js/**","/verifycode","/loginAjax"}; //不拦截哪些
        registry.addInterceptor(loginInterceptor).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns);
    }
}