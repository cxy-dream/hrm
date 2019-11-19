package com.first.hrm.services;

import com.first.hrm.bean.Employee;
import com.first.hrm.bean.EmployeeInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EmployeeSerivce {

    List<Employee> select();

    void addEmployee(Employee employee);

    void updateE(Employee employee);

    Employee selectById(Integer id);

    void deleteById(Integer id);

    List<Employee> findBy(Employee employee);

    //    public List<EmployeeInfo> findAll(EmployeeInfo employeeInfo) {
    void excl(HttpServletRequest request, HttpServletResponse response,Employee employeeInfo);


    List<EmployeeInfo> findAll(Employee employee);
}
