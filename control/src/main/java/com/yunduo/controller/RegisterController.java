package com.yunduo.controller;

import com.yunduo.bean.RegisterReq;
import com.yunduo.bean.RegisterRsq;
import com.yunduo.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Register",description = "注册页接口")
public class RegisterController {
    @Autowired
    RegisterService registerServer;

    @PostMapping("Register")
    @ApiOperation("注册信息填写")
    public RegisterRsq Register(RegisterReq model){
        return registerServer.register(model);
    }
}
