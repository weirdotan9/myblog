package com.twr.service;

import com.twr.entity.User;

public interface UserService {

    User checkUser(String username, String password);
}
