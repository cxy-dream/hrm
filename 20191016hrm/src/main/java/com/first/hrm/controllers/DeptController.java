package com.first.hrm.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.first.hrm.bean.Dept;
import com.first.hrm.bean.User;
import com.first.hrm.dao.DeptMapper;
import com.first.hrm.services.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/dept/loadDeptAjax")
    @ResponseBody
    public String  find(){
        List<Dept> depts = deptService.findAll();
        JSONArray array = new JSONArray();
        for(Dept dept:depts){
            JSONObject object = new JSONObject();
            object.put("id",dept.getId());
            object.put("name",dept.getName());
            array.add(object);
        }
        return array.toJSONString();
    }


    //查询所有部门
    @RequestMapping("/dept/deptList")
    public String findAll(Model model){

        List<Dept> depts = deptService.findAll();

        System.out.println(depts);
        model.addAttribute("depts",depts);
        return "dept/deptList";
    }

    //根据id删除一条数据
    @RequestMapping("/dept/deleteDept")
    public void deleteById(Integer id, HttpServletResponse response) throws IOException {

        deptService.deleteById(id);
        response.sendRedirect( "/dept/deptList");
    }

    //根据id来查询一条数据并发送到修改页面
    @RequestMapping("/dept/toUpdateDept")
    public String updateById(Integer id,Model model){
        Dept dept = deptService.findById(id);

        model.addAttribute("dept",dept);
        return "dept/updateDept";
    }
    @RequestMapping("/dept/updateDept")
    public void update(Dept dept, HttpServletResponse response) throws IOException {
        deptService.updateById(dept);
        response.sendRedirect("/dept/deptList");
    }


    //添加一条数据
    @RequestMapping("/dept/toAddDept")
    public String add(){
        return "dept/addDept";
    }
    @RequestMapping("/dept/addDept")
    public void addUser(Dept dept,HttpServletResponse response){

        deptService.addDept(dept);
        try {
            response.sendRedirect("/dept/deptList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
