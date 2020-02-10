package com.yunduo.service;

import com.yunduo.bean.*;

public interface UserInfoService {
    public LoginRsp Login(LoginReq model);
    public RegisterRsp register(RegisterReq model);
    public Integer updUserInfo(UpdUserInfoReq model);
    public FindUserInfoRsp findUserInfo(Integer userid);
    public StatisticsInfoRsp statisticsInfo(Integer account);
}
