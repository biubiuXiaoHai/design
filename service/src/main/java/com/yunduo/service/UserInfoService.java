package com.yunduo.service;

import com.github.pagehelper.PageInfo;
import com.yunduo.bean.*;
import com.yunduo.entities.Users;

import java.util.List;

public interface UserInfoService {
    public LoginRsp Login(LoginReq model);
    public RegisterRsp register(RegisterReq model);
    public Integer updUserInfo(UpdUserInfoReq model);
    public FindUserInfoRsp findUserInfo(Integer userid);
    public StatisticsInfoRsp statisticsInfo(Integer account);
    public PageInfo<Users> findUserFriend(FindUserFriendReq info);
}
