package com.httpapi.yyy.controller;

import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.bean.User;
import com.httpapi.yyy.service.UserService;
import com.httpapi.yyy.service.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value="登录数据", notes="登录数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "phone", value = "手机号(前端自己验证手机号合法性)", required = true, dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "pwd", value = "用户密码", required = true, dataType = "String",paramType = "query")
    })
    public Result userLogin(@RequestBody Map<String,String> userLogin) {
        return userService.userLogin(userLogin.get("phone"),userLogin.get("pwd"));
    }
    //注册
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value="注册情况", notes="注册情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号(前端自己验证手机号合法性)", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pwd", value = "用户密码", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "nickname ", value = "昵称(显示在我的页面上)", required = true, dataType = "String",paramType = "query")
    })
    public Result addUser(@RequestBody Map<String,String> addUser) {
        return userService.addUser(addUser.get("phone"),addUser.get("pwd"),addUser.get("nickname"));
    }
    //保存用户收获地址
    @RequestMapping(value = "/setAddress", method = RequestMethod.POST)
    @ApiOperation(value="保存用户收货地址", notes="保存用户收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "truename", value = "用户真实姓名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "address", value = " 收货地址", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "int",paramType = "query")
    })
    public Result setAddress(@RequestBody Map<String,String> user) {
        return userService.setAddress(user.get("truename"),user.get("address"),Integer.parseInt(user.get("uid")));
    }
}
