package com.first.hrm.services.impl;

import com.first.hrm.bean.Document;
import com.first.hrm.dao.DocumentMapper;
import com.first.hrm.services.DocumentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public List<Document> selectAll() {
        return documentMapper.select();
    }

    @Override
    public void addDocument(Document document) {
        documentMapper.insert(document);
    }

    @Override
    public Document findById(Integer id) {
        return documentMapper.selectById(id);
    }

    @Override
    public void updateById(Document document) {
        documentMapper.update(document);
    }

    @Override
    public void deleteById(Integer id) {
        documentMapper.delete(id);
    }

    @Override
    public List<Document> selectByTitle(String title) {

      Map<String, Object> map = new HashMap<>();

        if(StringUtils.isNotEmpty(title)){
            map.put("title","%"+title+"%");
        }
        System.out.println(title);

        return documentMapper.selectByTitle(map);
    }
}
