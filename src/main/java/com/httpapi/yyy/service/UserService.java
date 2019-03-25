package com.httpapi.yyy.service;

import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.bean.User;

import java.util.List;

public interface UserService {

    Result userLogin(String phone, String pwd);

    Result addUser(String phone,String pwd,String nickname );

    Result setAddress(String truename, String address, int uid);
}
