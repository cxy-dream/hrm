package com.first.hrm.services.impl;

import com.first.hrm.bean.Dept;
import com.first.hrm.dao.DeptMapper;
import com.first.hrm.services.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptSeviceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public Dept findById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.select();
    }

    @Override
    public void deleteById(Integer id) {

        deptMapper.delete(id);
    }

    @Override
    public void updateById(Dept dept) {

        deptMapper.update(dept);
    }

    @Override
    public void addDept(Dept dept) {

        deptMapper.insert(dept);
    }
}
