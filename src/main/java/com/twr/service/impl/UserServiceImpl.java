package com.twr.service.impl;

import com.twr.dao.UserDao;
import com.twr.entity.User;
import com.twr.service.UserService;
import com.twr.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        return userDao.getUserByUserNameAndPassword(username, MD5Utils.code(password));
    }
}
