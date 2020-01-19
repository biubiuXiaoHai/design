package com.yunduo.controller;

import com.yunduo.bean.LoginReq;
import com.yunduo.bean.LoginRsq;
import com.yunduo.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "登录页填写信息")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("Login")
    @ApiOperation("登录信息")
    public LoginRsq Login(LoginReq model){
//        System.out.println("进入到了 controller ！");
       return loginService.Login(model);
    }
}
