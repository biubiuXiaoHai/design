package com.yunduo.service.serviceImp;

import com.yunduo.bean.updUserHeadReq;
import com.yunduo.bean.updUserHeadRsp;
import com.yunduo.dao.UsersMapper;
import com.yunduo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImp implements HomeService {
    @Autowired
    UsersMapper usersMapper;

//    @Override
    public updUserHeadRsp updphone(updUserHeadReq model) {
////        Users user=new Users();
////        user.setAvatar( model.getPhoto());
////        usersMapper.updateByPrimaryKeySelective(user);
////        updUserHeadRsq result=new updUserHeadRsq();
////        result.setPhoto(model.getPhoto());
////        return result;
    return null;
    }
}
