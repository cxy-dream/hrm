package com.first.hrm.services;

import com.first.hrm.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {


    User findById(Integer id);

    List<User> findAll();

    void deleteById(Integer id);

    void updateById(User user);

    void addUser(User user);

    void checked(Integer id);

    public User findUserByIdAndPwd(User user);

}
