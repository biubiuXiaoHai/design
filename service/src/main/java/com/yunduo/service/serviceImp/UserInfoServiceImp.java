package com.yunduo.service.serviceImp;

import com.yunduo.bean.LoginReq;
import com.yunduo.bean.LoginRsq;
import com.yunduo.bean.RegisterReq;
import com.yunduo.bean.RegisterRsq;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.Users;
import com.yunduo.service.UserInfoService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImp  implements UserInfoService {
    @Autowired
    UsersMapper usersMapper;

    /**
     * 登录页
     * @param model
     * @return
     */
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

    /***
     * 注册页
     * @param model
     * @return
     */
    @Override
    public RegisterRsq register(RegisterReq model) {
        RegisterRsq registerRsq=new RegisterRsq();
        int result=usersMapper.selectByPhone(model.getPhone());
        if(result==0){
            Users user= CloneUtil.cloneObj(model, Users.class);
            usersMapper.insertSelective(user);
            user=usersMapper.selectByPhoneAll(user.getPhone());
            registerRsq.setResult(1);
            registerRsq.setAccount(user.getAccount());
            registerRsq.setPassword(user.getPassword());
//            registerRsq.setCreate_time(user.getCreate_time().toString());
            return registerRsq;
        }else{
            registerRsq.setResult(2);
            return registerRsq;
        }
    }
}
