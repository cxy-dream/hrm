package com.first.hrm.services.impl;

import com.first.hrm.bean.Notice;
import com.first.hrm.dao.NoticeMapper;
import com.first.hrm.services.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {


    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectAll() {
        return noticeMapper.select();
    }

    @Override
    public void addNotice(Notice notice) {
        notice.setUserId(1);
        noticeMapper.insert(notice);
    }

    @Override
    public Notice findById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public void updateById(Notice notice) {
        noticeMapper.update(notice);
    }

    @Override
    public List<Notice> selectById(String title) {

        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isNotEmpty(title)){
            map.put("title","%"+title+"%");
        }
        System.out.println(title);

        return noticeMapper.selectByTitle(map);
    }


}
