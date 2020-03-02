package com.yunduo.controller;

import com.github.pagehelper.PageInfo;
import com.yunduo.bean.AddFriendReq;
import com.yunduo.bean.FindFriendListReq;
import com.yunduo.entities.Users;
import com.yunduo.service.FriendsService;
import io.swagger.annotations.Api;
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
    @PostMapping("friendNumber")
    public Integer friendNumber(Integer account) {
        return friendsService.friendNumber(account);
    }

    /**
     * 获取好友的列表
     */
    @PostMapping("findFriendList")
    public PageInfo<Users> findFriendList(FindFriendListReq model) {
        return friendsService.findFriendList(model);
    }

    /**
     * 添加好友功能
     */
    @PostMapping("addFriend")
    public Integer addFriend(AddFriendReq model){
        return friendsService.addFriend(model);
    }
}
