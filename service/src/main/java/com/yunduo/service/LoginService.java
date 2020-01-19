package com.yunduo.service;

import com.yunduo.bean.LoginReq;
import com.yunduo.bean.LoginRsq;

public interface LoginService {
    public LoginRsq Login(LoginReq model);
}
