package com.yunduo.service;

import com.yunduo.bean.RegisterReq;
import com.yunduo.bean.RegisterRsq;

public interface RegisterService {
    public RegisterRsq register(RegisterReq model);
}
