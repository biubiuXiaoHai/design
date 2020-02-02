package com.yunduo.service;

import com.yunduo.bean.LoginReq;
import com.yunduo.bean.LoginRsq;
import com.yunduo.bean.RegisterReq;
import com.yunduo.bean.RegisterRsq;

public interface UserInfoService {
    public LoginRsq Login(LoginReq model);
    public RegisterRsq register(RegisterReq model);

}
