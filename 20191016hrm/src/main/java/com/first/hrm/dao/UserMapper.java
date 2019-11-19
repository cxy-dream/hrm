package com.first.hrm.dao;

import com.first.hrm.base.BaseMapper;
import com.first.hrm.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper 数据访问类

 * @date 2019-10-16 15:38:33
 * @version 1.0
 */

@Mapper
public interface UserMapper extends BaseMapper {

    void checked(@Param("id") Integer id,@Param("status") Integer status);


    public User findUserByIdAndPwd(@Param("name") String name,@Param("passWord") String pwd);
}