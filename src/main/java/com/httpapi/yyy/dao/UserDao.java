package com.httpapi.yyy.dao;

import com.httpapi.yyy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public interface UserDao {


    List<User> userLogin(String phone, String pwd);

    List<User> addUser(String phone, String pwd, String nickname);

    void setAddress(String truename, String address, int uid);
}
