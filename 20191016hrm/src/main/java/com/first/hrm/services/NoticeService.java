package com.first.hrm.services;

import com.first.hrm.bean.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> selectAll();

    void addNotice(Notice notice);

    Notice findById(Integer id);

    void updateById(Notice notice);

    List<Notice> selectById(String title);
}
