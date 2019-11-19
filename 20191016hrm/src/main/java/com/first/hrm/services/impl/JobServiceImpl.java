package com.first.hrm.services.impl;

import com.first.hrm.bean.Dept;
import com.first.hrm.bean.Job;
import com.first.hrm.dao.JobMapper;
import com.first.hrm.services.JobSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobSerivce {

    @Autowired
    private JobMapper jobMapper;


    @Override
    public Job findById(Integer id) {
        return jobMapper.selectById(id);
    }

    @Override
    public List<Job> findAll() {
        return jobMapper.select();
    }

    @Override
    public void deleteById(Integer id) {

        jobMapper.delete(id);
    }

    @Override
    public void updateById(Job job) {

        jobMapper.update(job);
    }

    @Override
    public void addJob(Job job) {

        jobMapper.insert(job);
    }
}
