package com.first.hrm.services;

import com.first.hrm.bean.Dept;
import com.first.hrm.bean.User;

import java.util.List;

public interface DeptService {

    Dept findById(Integer id);

    List<Dept> findAll();

    void deleteById(Integer id);

    void updateById(Dept dept);

    void addDept(Dept dept);
}
