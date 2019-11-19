package com.first.hrm.controllers;

import com.first.hrm.bean.Document;
import com.first.hrm.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class DocumentController {

@Autowired
private DocumentService documentService;

    //添加一条数据
    @RequestMapping("/document/toAddDocument")
    public String toAddDocument(){

        return "document/addDocument";
    }
    @RequestMapping("/document/addDocument")
    public String addDocument(MultipartFile file, HttpServletResponse response , HttpServletRequest request, Document document) throws IOException {

        //保存文件的路径
        String realPath = request.getServletContext().getRealPath("/images");
        //将文件名修改防止覆盖
        String s = UUID.randomUUID()+file.getOriginalFilename();

        file.transferTo(new File(realPath+File.separator+s));
        document.setUrl(realPath+File.separator+s);
        document.setCreateDate(new Date());
        document.setUserId(1);
        documentService.addDocument(document);
        return "redirect:/document/documentList";
    }


    //查询所有的信息
    @RequestMapping("/document/documentList")
    public String selectDocument(Model model){
        List<Document> documents = documentService.selectAll();
        model.addAttribute("documents",documents);
        return "document/documentList";
    }



    //根据id修改文件信息
    @RequestMapping("/document/toUpdateDocument")
    public String selectById(Integer id,Model model){
        Document document = documentService.findById(id);
        model.addAttribute("document",document);
        return "document/updateDocument";
    }

    @RequestMapping("/document/updateDocument")
    public String updateById(Document document){
        documentService.updateById(document);
        return "redirect:/document/documentList";
    }

    //根据id删除一条数据
    @RequestMapping("/document/deleteDocument")
    public String deleteById(Integer id){
        documentService.deleteById(id);
        return "redirect:/document/documentList";
    }


    //下载文件
    @RequestMapping("/document/downDocument")
    public void downLoad(Integer id,HttpServletResponse response){

        Document document = documentService.findById(id);
        String url = document.getUrl();
        response.setHeader("content-type","application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+url);

        byte [] b = new byte[1024];

        BufferedInputStream bs=null;
        OutputStream os=null;
        try {
            bs = new BufferedInputStream(new FileInputStream(new File(url)));
            os = response.getOutputStream();

            int i = bs.read(b);
            while (i!=-1){
                os.write(b,0,b.length);
                os.flush();
                i = bs.read(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os!=null) {
                try {
                    os.close();
                    bs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //根据搜索条件查询文档
    @RequestMapping("/document/selectDocument")
    public String selectList(String title,Model model){
        List<Document> documents = documentService.selectByTitle(title);
        model.addAttribute("documents",documents);
        return "document/documentList";
    }
}
