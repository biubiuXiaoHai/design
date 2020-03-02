package com.yunduo.controller;

import com.github.pagehelper.PageInfo;
import com.yunduo.bean.*;
import com.yunduo.entities.Users;
import com.yunduo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(value = "UserInfoController" ,description = "用户信息")
@RestController
@RequestMapping("userinfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    /***   已完成无误
     * 登录
     * @param model
     * @return
     */
    @PostMapping("login")
    @ApiOperation("登录信息")
    public LoginRsp Login(LoginReq model){
        return userInfoService.Login(model);
    }

    /**  已完成无误
     * 注册
     * @param model
     * @return
     */
    @PostMapping("register")
    @ApiOperation("注册信息填写")
    public RegisterRsp Register(RegisterReq model){
        return userInfoService.register(model);
    }

    /**
     * 获取个人用户信息
     */
    @PostMapping("findUserInfo")
    @ApiOperation("获取用户个人信息")
    public FindUserInfoRsp findUserInfo(Integer userid){
     return   userInfoService.findUserInfo(userid);
    }

    /**  已完成
     * 修改用户信息
     */
    @PostMapping("updUserInfo")
    @ApiOperation("修改用户个人信息")
    public Integer updUserInfo(UpdUserInfoReq model){
        return userInfoService.updUserInfo(model);
    }
    /**
     * 更换头像 (转换显示)
     * @param file
     * @return
     */
    @PostMapping("updateInfo")
    @ApiOperation("仅仅只是转换头像的实时显示而已，不改数据库")
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
//            System.out.println(dest.getPath());
//        System.out.println("路径："+dest.getPath()+"    文件名"+dest.getName());
        return "http://127.0.0.1:8090/temp-rainy/"+fileName;
    }

    /**
     * 左侧统计总览信息（说说/留言/相册数量）
     */
    @PostMapping("statisticsInfo")
    @ApiOperation("左侧统计总览信息（说说/留言/相册数量）")
    public StatisticsInfoRsp statisticsInfo(Integer account){
        return userInfoService.statisticsInfo(account);
    }

    /**好友动态页的
     *
     * 好友列表
     * 入：主id
     * 出：好友头像和昵称，id
     */

    /**好友动态页的
     *
     * 搜索好友
     */
    @PostMapping("findUserFriend")
    @ApiOperation("搜索好友(通过账号，手机号，昵称等搜素)")
    public List<Users> findUserFriend(String  info){
        return userInfoService.findUserFriend(info);
    }
}


