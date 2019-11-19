package com.first.hrm.controllers;


import com.first.hrm.bean.Notice;
import com.first.hrm.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    //显示所有信息
    @RequestMapping("/notice/noticeList")
    public String select(Model model){
        List<Notice> notices = noticeService.selectAll();
        model.addAttribute("notices",notices);
        return "notice/noticeList";
    }

    //准备添加
    @RequestMapping("/notice/toAddNotice")
    public String toAdd(){
        return "notice/addNotice";
    }
    //添加
    @RequestMapping("/notice/addNotice")
    public String add(Notice notice){
        noticeService.addNotice(notice);
        return "notice/noticeList";
    }

    //准备修改
    @RequestMapping("/notice/toUpdateNotice")
    public String toUpdate(Integer id,Model model){

        Notice notice = noticeService.findById(id);
        model.addAttribute("notice",notice);
        return "notice/updateNotice";
    }

    //修改
    @RequestMapping("/notice/updateNotice")
    public String updateNotice(Notice notice){
        noticeService.updateById(notice);
        return "notice/updateNotice";
    }

    //预览
    @RequestMapping("/notice/prevNotice")
    public String prev(Integer id,Model model){
        Notice notice = noticeService.findById(id);
        model.addAttribute(notice);
        return "notice/updateNotice";
    }

    @RequestMapping("/notice/selectNotice")
    public String checked(String title,Model model){
        List<Notice> notices = noticeService.selectById(title);
        model.addAttribute("notices",notices);
        return "notice/noticeList";
    }


    //加载资源
    @RequestMapping("/notice/uploadPic")
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request){

        String realPath = request.getServletContext().getRealPath("/images");
        String s = UUID.randomUUID().toString() + file.getOriginalFilename();
        try {
            file.transferTo(new File(realPath+File.separator+s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/images/"+s;
    }

}
