package com.first.hrm.services;

import com.first.hrm.bean.Dept;
import com.first.hrm.bean.Job;

import java.util.List;

public interface JobSerivce {

    Job findById(Integer id);

    List<Job> findAll();

    void deleteById(Integer id);

    void updateById(Job job);

    void addJob(Job job);
}
