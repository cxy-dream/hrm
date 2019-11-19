package com.first.hrm.controllers;


import com.alibaba.fastjson.JSONObject;
import com.first.hrm.base.WebConfig;
import com.first.hrm.bean.User;
import com.first.hrm.constant.WebConstant;
import com.first.hrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/loginAjax")
    @ResponseBody
    public String login(HttpServletRequest request,String code,String userId,String password){
        //判断验证码，首先获取服务器端验证码controller生成的原始验证码
        String oldCode=(String)request.getSession().getAttribute(WebConstant.VERIFY_CODE);

        //创建一个jsonObject
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tip","验证码不正确");
        jsonObject.put("flag",1);
        if(code.equalsIgnoreCase(oldCode)){
            //如果验证码正确，然后根据用户提交的用户名和密码去数据库校验该该用户名和密码是否存在
            User user= new User();
            user.setName(userId);
            user.setPassWord(password);
            User userByIdAndPwd = userService.findUserByIdAndPwd(user);
            if(userByIdAndPwd!=null){
                request.getSession().setAttribute(WebConstant.SESSION_USER,userByIdAndPwd);
                if (userByIdAndPwd.getStatus()!=0) {
                    jsonObject.put("tip", "登录成功");
                    jsonObject.put("flag", 0);
                }
                else {
                    jsonObject.put("tip", "用户账号未审批，请联系管理员进行审批");
                    jsonObject.put("flag", 1);
                }

            }else {
                jsonObject.put("tip","用户名和密码不正确");
                jsonObject.put("flag",2);
            }
        }

        return  jsonObject.toString();

    }




}
