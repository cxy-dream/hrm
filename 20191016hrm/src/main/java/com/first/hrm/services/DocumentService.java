package com.first.hrm.services;

import com.first.hrm.bean.Document;

import java.util.List;

public interface DocumentService {


    List<Document> selectAll();

    void addDocument(Document document);

    Document findById(Integer id);

    void updateById(Document document);

    void deleteById(Integer id);

    List<Document> selectByTitle(String title);

}
