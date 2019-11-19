package com.first.hrm.controllers;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.first.hrm.bean.User;
import com.first.hrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @ResponseBody
    @RequestMapping("/index/{id}")
    public String findById(@PathVariable("id") Integer id){

        User user = userServiceImpl.findById(id);

        return "index";
    }



    //查询所有用户
    @RequestMapping("/user/userList")
    public String findAll(Model model){

        List<User> users = userServiceImpl.findAll();

        System.out.println(users);
        model.addAttribute("users",users);
        return "user/userList";
    }

    //根据id删除一条数据
    @RequestMapping("/user/deleteUser")
    public void deleteById(Integer id,HttpServletResponse response) throws IOException {

        userServiceImpl.deleteById(id);
        response.sendRedirect( "/user/userList");
    }

    //根据id来查询一条数据并发送到修改页面
    @RequestMapping("/user/toUpdateUser")
    public String updateById(Integer id,Model model){
        User user = userServiceImpl.findById(id);

        model.addAttribute("user",user);
        return "user/updateUser";
    }
    @RequestMapping("/user/updateUser")
        public void update(User user, HttpServletResponse response) throws IOException {
        userServiceImpl.updateById(user);
        response.sendRedirect("/user/userList");
    }


    //添加一条数据
    @RequestMapping("/user/toAddUser")
    public String add(){
        return "user/addUser";
    }
    @RequestMapping("/user/addUser")
    public void addUser(User user,HttpServletResponse response){

        userServiceImpl.addUser(user);
        try {
            response.sendRedirect("/user/userList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/user/checkUser")
    public void checked(Integer id ,HttpServletResponse response) throws IOException {

        userServiceImpl.checked(id);
        response.sendRedirect("/user/userList");
    }

}
