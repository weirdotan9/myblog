package com.twr.dao;

import com.twr.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User getUserByUserNameAndPassword(@Param("username") String username,@Param("password") String password);

}
