package com.yunduo.service.serviceImp;

import com.yunduo.bean.RegisterReq;
import com.yunduo.bean.RegisterRsq;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.Users;
import com.yunduo.service.RegisterService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp  implements RegisterService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public RegisterRsq register(RegisterReq model) {
        RegisterRsq registerRsq=new RegisterRsq();
        int result=usersMapper.selectByPhone(model.getPhone());
        if(result==0){
            Users user=CloneUtil.cloneObj(model, Users.class);
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
