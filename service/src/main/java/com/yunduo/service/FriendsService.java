package com.yunduo.service;

import com.github.pagehelper.PageInfo;
import com.yunduo.bean.AddFriendReq;
import com.yunduo.bean.FindFriendListReq;
import com.yunduo.entities.Users;

public interface FriendsService {
    public Integer friendNumber(Integer master_id);
    public PageInfo<Users> findFriendList(FindFriendListReq model);
    public Integer addFriend(AddFriendReq model);
}
