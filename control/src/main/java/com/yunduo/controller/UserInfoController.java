package com.yunduo.controller;

import com.yunduo.bean.*;
import com.yunduo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Api(value = "UserInfoController" ,description = "用户信息")
@RestController
@RequestMapping("userinfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    /***
     * 登录
     * @param model
     * @return
     */
    @PostMapping("login")
    @ApiOperation("登录信息")
    public LoginRsq Login(LoginReq model){
        return userInfoService.Login(model);
    }

    /**
     * 注册
     * @param model
     * @return
     */
    @PostMapping("register")
    @ApiOperation("注册信息填写")
    public RegisterRsq Register(RegisterReq model){
        return userInfoService.register(model);
    }

    @PostMapping("updateInfo")
    public String updateInfo(@RequestParam("file") MultipartFile file){
        System.out.println("ok it work");
        //获取原来的文件名
        String fileName=file.getOriginalFilename();
        String fileLast=fileName.substring(fileName.lastIndexOf("."));
        //取得新文件夹名
        fileName= UUID.randomUUID()+fileLast;
        System.out.println("新文件夹名字："+fileName);

        String filePath="D:/temp-rainy/";
        File dest=new File(filePath+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try{
            file.transferTo(dest);
        } catch (IOException e) {
            System.out.println("传输过程有误！");
            e.printStackTrace();
        }
            System.out.println(dest.getPath());
        System.out.println("路径："+dest.getPath()+"    文件名"+dest.getName());
        return "http://localhost:8080/temp-rainy/"+fileName;
//        return null;
    }
}


