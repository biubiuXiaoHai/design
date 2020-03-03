package com.yunduo.controller;

import com.github.pagehelper.PageInfo;
import com.yunduo.bean.*;
import com.yunduo.entities.Users;
import com.yunduo.service.FriendsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "friendsController" ,description = "好友关系")
@RequestMapping("friends")
public class FriendsController {
    @Autowired
    FriendsService friendsService;

    /**
     * 获取好友数量
     */
    @PostMapping("findFriendNumber")
    @ApiOperation("获取好友数量")
    public Integer findFiendNumber(Integer account) {
        return friendsService.friendNumber(account);
    }

    /**
     * 获取好友的列表
     */
    @PostMapping("findFriendList")
    @ApiOperation("获取好友的列表")
    public PageInfo<Users> findFriendList(FindFriendListReq model) {
        return friendsService.findFriendList(model);
    }

    /**
     * 点击 添加好友
     */
    @PostMapping("addFriend")
    @ApiOperation("添加好友功能")
    public Integer addFriend(AddFriendReq model){
        return friendsService.addFriend(model);
    }

    /**
     * 添加好友成功
     *
     * @param model
     * @return
     */
    @PostMapping("addFriendSuccess")
    public Integer addFriendSuccess(AddFriendSuccessReq model){
       return  friendsService.addFriendSuccess(model);
    }
    /**
     * 对方拒绝了添加为好友
     */
    @PostMapping("addFriendfail")
    public Integer addFriendfail(AddFriendfailReq model){
       return friendsService.addFriendFail(model);
    }
    /**
     * 删除好友
     */
    @PostMapping("deleteFriend")
    public Integer deleteFriend(DeleteFriendReq model){
        return  friendsService.deleteFriend(model);

    }

}
