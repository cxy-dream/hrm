package com.first.hrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //退出功能 销毁当前用户保存在服务器端的session信息
        request.getSession().invalidate();
        response.sendRedirect("/tologin");

    }

}
