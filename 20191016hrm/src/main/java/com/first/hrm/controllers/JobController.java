package com.first.hrm.controllers;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.first.hrm.bean.Dept;
import com.first.hrm.bean.Job;
import com.first.hrm.services.JobSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobSerivce jobSerivce;

    @RequestMapping("/job/loadJobAjax")
    @ResponseBody
    public String  find(){
        List<Job> jobs = jobSerivce.findAll();
        JSONArray array = new JSONArray();
        for(Job job:jobs){
            JSONObject object = new JSONObject();
            object.put("id",job.getId());
            object.put("name",job.getName());
            array.add(object);
        }
        return array.toJSONString();
    }


    //查询所有部门
    @RequestMapping("/job/jobList")
    public String findAll(Model model){

        List<Job> jobs = jobSerivce.findAll();

        System.out.println(jobs);
        model.addAttribute("jobs",jobs);
        return "job/jobList";
    }

    //根据id删除一条数据
    @RequestMapping("/job/deleteJob")
    public void deleteById(Integer id, HttpServletResponse response) throws IOException {

        jobSerivce.deleteById(id);
        response.sendRedirect( "/job/jobList");
    }

    //根据id来查询一条数据并发送到修改页面
    @RequestMapping("/job/toUpdateJob")
    public String updateById(Integer id,Model model){
        Job job = jobSerivce.findById(id);

        model.addAttribute("job",job);
        return "job/updateJob";
    }
    @RequestMapping("/job/updateJob")
    public void update(Job job, HttpServletResponse response) throws IOException {
        jobSerivce.updateById(job);
        response.sendRedirect("/job/jobList");
    }


    //添加一条数据
    @RequestMapping("/job/toAddJob")
    public String add(){
        return "job/addJob";
    }
    @RequestMapping("/job/addJob")
    public void addUser(Job job,HttpServletResponse response){

        jobSerivce.addJob(job);
        try {
            response.sendRedirect("/job/jobList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
