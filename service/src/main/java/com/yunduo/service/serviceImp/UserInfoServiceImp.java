package com.yunduo.service.serviceImp;

import com.github.pagehelper.PageInfo;
import com.yunduo.bean.*;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.Users;
import com.yunduo.service.UserInfoService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public LoginRsp Login(LoginReq model) {
        LoginRsp loginRsq=new LoginRsp();
        //先取手机号来判断
        Users user =usersMapper.selectByPhoneAll(model.getAccount().toString());
        if(user!=null && model.getAccount().toString().equals(user.getPhone())){
            if(user.getPassword().equals(model.getPassword())) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date=new Date();
//                System.out.println(formatter.format(date));
                String time=formatter.format(date);
                if(!user.getLast_date().equals(time)){
                    user.setSum_date(user.getSum_date()+1);
                    user.setLast_date(time);
                    usersMapper.updateByPrimaryKeySelective(user);
                }
                loginRsq.setResult(1);
                loginRsq.setAccount(user.getAccount());
                loginRsq.setName(user.getName());
                return loginRsq;
            }
            loginRsq.setResult(3);
            return loginRsq;
        }
        //取云朵账号来判断
        user= usersMapper.selectByPrimaryKey(model.getAccount());
        if(user!=null&&model.getAccount().equals(user.getAccount())){
            if(user.getPassword().equals(model.getPassword())) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date=new Date();
//                System.out.println(formatter.format(date));
                String time=formatter.format(date);
                if(!user.getLast_date().equals(time)){
                    user.setSum_date(user.getSum_date()+1);
                    user.setLast_date(time);
                    usersMapper.updateByPrimaryKeySelective(user);
                }
                loginRsq.setResult(1);
                loginRsq.setAccount(user.getAccount());
                loginRsq.setName(user.getName());
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
    public RegisterRsp register(RegisterReq model) {
        RegisterRsp registerRsp =new RegisterRsp();
        int result=usersMapper.selectByPhone(model.getPhone());
        if(result==0){
            Users user= CloneUtil.cloneObj(model, Users.class);
            user.setAvatar("../images/兔子.jpg");
            usersMapper.insertSelective(user);
            user=usersMapper.selectByPhoneAll(user.getPhone());
            registerRsp.setResult(1);
            registerRsp.setAccount(user.getAccount());
            registerRsp.setPassword(user.getPassword());
            return registerRsp;
        }else{
            registerRsp.setResult(2);
            return registerRsp;
        }
    }

    @Override
    public Integer updUserInfo(UpdUserInfoReq model) {
        String filename=model.getFile().getOriginalFilename();
        String filelast=filename.substring(filename.lastIndexOf("."));
        filename= UUID.randomUUID()+filelast;
        String filepath="D:/temp-rainy/";
        File dest =new File(filepath+filename);
        try{
            model.getFile().transferTo(dest);
        } catch (IOException e) {
            System.out.println("传输过程异常！");
            e.printStackTrace();
        }
//        model.setAvatar(filepath+filename);
        Users user=CloneUtil.cloneObj(model,Users.class);
        user.setAvatar(filepath+filename);
        usersMapper.updateByPrimaryKeySelective(user);
        System.out.println("更新成功了！");
        return 1;
    }

    /**
     * 获取用户信息
     * @param userid
     * @return
     */
    @Override
    public FindUserInfoRsp findUserInfo(Integer userid) {
        Users users =usersMapper.selectByPrimaryKey(userid);
//        if(users.getAvatar().equals(null)){
////            users.setAvatar("../../images/兔子.jpg");
////        }
        FindUserInfoRsp userInfoRsq=CloneUtil.cloneObj(users, FindUserInfoRsp.class);
        return userInfoRsq;
    }

    @Override
    public StatisticsInfoRsp statisticsInfo(Integer account) {
//        等后期再开发
        return null;
    }

    /**
     * 查找好友用户
     * @param info
     * @return
     */
    @Override
    public List<Users> findUserFriend(String info) {
    return  usersMapper.findUserFriend(info);
    }
}
