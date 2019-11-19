package com.first.hrm.services.impl;

import com.first.hrm.bean.User;
import com.first.hrm.dao.UserMapper;
import com.first.hrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserservicesImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.select();
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public void updateById(User user) {
        userMapper.update(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void checked(Integer id) {
        userMapper.checked(id,1);
    }

    @Override
    public User findUserByIdAndPwd(User user) {
        return userMapper.findUserByIdAndPwd(user.getName(),user.getPassWord());
    }


}
