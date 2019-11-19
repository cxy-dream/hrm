package com.first.hrm.controllers;


import com.first.hrm.bean.Dept;
import com.first.hrm.bean.Employee;
import com.first.hrm.bean.EmployeeInfo;
import com.first.hrm.services.DeptService;
import com.first.hrm.services.EmployeeSerivce;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Controller
public class EmployeeController {


    @Autowired
    private EmployeeSerivce employeeSerivce;
    @Autowired
    private DeptService deptService;

    //查询所有
    @RequestMapping("/emp/empList")
    public String findAll(Model model){

        List<Employee> employees = employeeSerivce.select();

        model.addAttribute("employees",employees);
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        return "emp/empList";
    }

    //准备添加
    @RequestMapping("/emp/toAddEmp")
    public String toAddEmploy(){
        return "emp/addEmp";
    }
    //添加
    @RequestMapping("/employee/addEmp")
    public String addEmploy(Employee employee){
        employeeSerivce.addEmployee(employee);
        return "redirect:/emp/empList";
    }
    //准备修改
    @RequestMapping("/emp/toUpdateEmp")
    public String toUpdateById(Integer id,Model model){
        Employee employee = employeeSerivce.selectById(id);
        System.out.println(employee);
        model.addAttribute("emp",employee);
        return "emp/updateEmp";
    }
    //修改
    @RequestMapping("emp/updateEmp")
    public String updateById(Employee employee){
        System.out.println(employee);
        employeeSerivce.updateE(employee);
        return "redirect:/emp/empList";
    }

    //根据id删除一条数据
    @RequestMapping("/emp/deleteEmp")
    public String deleteById(Integer id){
        employeeSerivce.deleteById(id);
        return "redirect:/emp/empList";

    }

    //模糊查询
    @RequestMapping("/employee/selectEmployee")
    public String findById(Employee employee,Model model){
        List<Employee> employees= employeeSerivce.findBy(employee);
        System.out.println(employees+"111111111111111111");
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        model.addAttribute("employees",employees);
        return "emp/empList";
    }

    @RequestMapping("/employee/downExcel")
    public void Excl(HttpServletResponse response,HttpServletRequest request,Employee employee){
        System.out.println(employee);
        employeeSerivce.excl(request,response,employee);



    }

}
