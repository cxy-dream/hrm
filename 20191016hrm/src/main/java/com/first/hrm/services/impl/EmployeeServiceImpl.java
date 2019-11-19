package com.first.hrm.services.impl;

import com.first.hrm.bean.Employee;
import com.first.hrm.bean.EmployeeInfo;
import com.first.hrm.dao.EmployeeMapper;
import com.first.hrm.services.EmployeeSerivce;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeSerivce {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> select() {
        return employeeMapper.select();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void updateE(Employee employee) {

        employeeMapper.update(employee);
    }

    @Override
    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        employeeMapper.delete(id);
    }

    @Override
    public List<Employee> findBy(Employee employee) {
        Map<String, Object> map = new HashMap<>();

        if(StringUtils.isNotEmpty(employee.getCardId())){
            map.put("cardId","%"+employee.getCardId()+"%");
        }
        if(StringUtils.isNotEmpty(employee.getName())){
            map.put("name","%"+employee.getName()+"%");
        }
        if(StringUtils.isNotEmpty(employee.getPhone())){
            map.put("phone","%"+employee.getPhone()+"%");
        } if(employee.getSex()!=0){
            map.put("sex",employee.getSex());
        }
        if(employee.getDeptId()!=0){

            map.put("deptId",employee.getDeptId());
        }
        if(employee.getJobId()!=0){
            map.put("jobId",employee.getJobId());
        }

        return employeeMapper.findBy(map);
    }

    @Override
    public List<EmployeeInfo> findAll(Employee employee){
        Map<String, Object> map = new HashMap<>();

        if(StringUtils.isNotEmpty(employee.getCardId())){
            map.put("cardId","%"+employee.getCardId()+"%");
        }
        if(StringUtils.isNotEmpty(employee.getName())){
            map.put("name","%"+employee.getName()+"%");
        }
        if(StringUtils.isNotEmpty(employee.getPhone())){
            map.put("phone","%"+employee.getPhone()+"%");
        } if(employee.getSex()!=0){
            map.put("sex",employee.getSex());
        }
        if(employee.getDeptId()!=0){
            map.put("deptId",employee.getDeptId());
        }
        if(employee.getJobId()!=0){
            map.put("jobId",employee.getJobId());
        }

        return employeeMapper.findAll(map);
    }

    @Override
//
      public void excl(HttpServletRequest request, HttpServletResponse response,Employee employee){
        System.out.println(employee);
        List<EmployeeInfo> all = findAll(employee);
        System.out.println(all);
//        List<EmployeeInfo> all = employeeMapper.findAll(null);
        String[] head = {"编号","部门","职位","姓名","身份证","联系地址","手机号码","邮箱","性别","学历","创建日期"};
        String sheetName = "员工信息";
        HSSFWorkbook hb = new HSSFWorkbook();
        HSSFSheet sheet = hb.createSheet(sheetName);
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i <head.length ; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(head[i]);
        }
        for (int i = 0; i <all.size() ; i++) {
            row = sheet.createRow(i+1);
            EmployeeInfo info = all.get(i);
            Field[] fields = info.getClass().getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {

                Field field = fields[j];
                HSSFCell cell = row.createCell(j);
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }

                try {
                    Object o = field.get(info);
                    cell.setCellValue(o.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        response.setHeader("Content-Disposition","attachment;filename=employeeinfo.xls");
        try {
            hb.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
