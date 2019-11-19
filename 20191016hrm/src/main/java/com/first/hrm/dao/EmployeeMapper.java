package com.first.hrm.dao;

import com.first.hrm.base.BaseMapper;
import com.first.hrm.bean.Employee;
import com.first.hrm.bean.EmployeeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * EmployeeMapper 数据访问类

 * @date 2019-10-16 15:38:33
 * @version 1.0
 */

@Mapper
public interface EmployeeMapper extends BaseMapper {

    List<Employee> findBy(Map<String,Object> map);

    List<EmployeeInfo> findAll(Map<String,Object> map);


}