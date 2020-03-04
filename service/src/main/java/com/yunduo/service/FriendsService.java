package com.yunduo.service;

import com.github.pagehelper.PageInfo;
import com.yunduo.bean.*;
import com.yunduo.entities.Users;

public interface FriendsService {
    public Integer friendNumber(Integer master_id);
    public PageInfo<Users> findFriendList(FindFriendListReq model);
    public Integer addFriend(AddFriendReq model);
    public Integer addFriendSuccess(AddFriendSuccessReq model);
    public Integer addFriendFail(AddFriendFailReq model);
    public Integer deleteFriend(DeleteFriendReq model);
}
