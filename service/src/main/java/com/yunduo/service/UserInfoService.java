package com.yunduo.service;

import com.yunduo.bean.*;

public interface UserInfoService {
    public LoginRsq Login(LoginReq model);
    public RegisterRsq register(RegisterReq model);
    public FindUserInfoRsq findUserInfo(Integer userid);
}
