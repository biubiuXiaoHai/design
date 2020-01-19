package com.yunduo.service.serviceImp;

import com.yunduo.bean.LoginReq;
import com.yunduo.bean.LoginRsq;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.Users;
import com.yunduo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    public LoginRsq Login(LoginReq model) {
        LoginRsq loginRsq=new LoginRsq();
        //先取手机号来判断
        Users user =usersMapper.selectByPhoneAll(model.getAccount().toString());
        if(user!=null && model.getAccount().toString().equals(user.getPhone())){
            if(user.getPassword().equals(model.getPassword())) {
                loginRsq.setResult(1);
                loginRsq.setAccount(user.getAccount());
                return loginRsq;
            }
            loginRsq.setResult(3);
            return loginRsq;
            }
        //取云朵账号来判断
        user= usersMapper.selectByPrimaryKey(model.getAccount());
        if(user!=null&&model.getAccount().equals(user.getAccount())){
            if(user.getPassword().equals(model.getPassword())) {
                loginRsq.setResult(1);
                loginRsq.setAccount(user.getAccount());
                return loginRsq;
            }
            loginRsq.setResult(3);
            return loginRsq;
        }
        loginRsq.setResult(2);
        return loginRsq;
    }
}
