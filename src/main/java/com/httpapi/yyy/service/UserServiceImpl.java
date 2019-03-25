package com.httpapi.yyy.service;

import com.httpapi.yyy.bean.Commodity;
import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.bean.User;
import com.httpapi.yyy.dao.UserDao;
import com.httpapi.yyy.util.MD5Utils;
import com.httpapi.yyy.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Result userLogin(String phone, String pwd) {
        List<User> userInfo = userDao.userLogin(phone, MD5Utils.encode(pwd));
        return userInfo.isEmpty() ? ResultUtil.error("登录失败") : ResultUtil.success(userInfo);
    }

    @Override
    public Result addUser(String phone, String pwd, String nickname) {
        List<User> addUser=null;
        try{
           addUser = userDao.addUser(phone, MD5Utils.encode(pwd),nickname);
        }catch(Exception E){
          return  ResultUtil.error("注册失败");
        }

        return ResultUtil.success(addUser);
    }

    @Override
    public Result setAddress(String truename, String address, int uid) {

        try{
            userDao.setAddress(truename,address,uid);
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }

        return  ResultUtil.success("添加地址成功");
    }
}
