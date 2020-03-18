package com.yunduo.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunduo.bean.*;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.Users;
import com.yunduo.service.UserInfoService;
import com.yunduo.utils.CloneUtil;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    UsersMapper usersMapper;

    /**
     * 登录页
     *
     * @param model
     * @return
     */
    @Override
    public LoginRsp Login(LoginReq model) {
        LoginRsp loginRsq = new LoginRsp();
        //输入格式的判断
        if(model.getAccount().length()!=6&&model.getAccount().length()!=11){
            loginRsq.setResult(2);
            return loginRsq;
        }
        //先取手机号来判断
        Users user = usersMapper.selectByPhoneAll(model.getAccount());
        if (user != null && model.getAccount().equals(user.getPhone())) {
            if (user.getPassword().equals(model.getPassword())) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
//                System.out.println(formatter.format(date));
                String time = formatter.format(date);
                if (!user.getLast_date().equals(time)) {
                    user.setSum_date(user.getSum_date() + 1);
                    user.setLast_date(time);
                    usersMapper.updateByPrimaryKeySelective(user);
                }
                //登录成功
                loginRsq.setResult(1);
                loginRsq.setAccount(user.getAccount());
                loginRsq.setName(user.getName());
                return loginRsq;
            }
            //密码错误
            loginRsq.setResult(3);
            return loginRsq;
        }
        //取云朵账号来判断
        user = usersMapper.selectByPrimaryKey(Integer.valueOf(model.getAccount()));
        if (user != null && (Integer.valueOf(model.getAccount()).equals(user.getAccount()))) {
            if (user.getPassword().equals(model.getPassword())) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
//                System.out.println(formatter.format(date));
                String time = formatter.format(date);
                if (!user.getLast_date().equals(time)) {
                    user.setSum_date(user.getSum_date() + 1);
                    user.setLast_date(time);
                    usersMapper.updateByPrimaryKeySelective(user);
                }
                loginRsq.setResult(1);
                loginRsq.setAccount(user.getAccount());
                loginRsq.setName(user.getName());
                return loginRsq;
            }
            //登录失败,密码错误
            loginRsq.setResult(3);
            return loginRsq;
        }
        //result=2账号不存在
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
        RegisterRsp registerRsp = new RegisterRsp();
        int result = usersMapper.selectByPhone(model.getPhone());
        if (result == 0) {
            Users user = CloneUtil.cloneObj(model, Users.class);
            user.setAvatar("/images/兔子.jpg");
            usersMapper.insertSelective(user);
            user = usersMapper.selectByPhoneAll(user.getPhone());
            registerRsp.setResult(1);
            registerRsp.setAccount(user.getAccount());
            registerRsp.setPassword(user.getPassword());

            //使用第三方短信系统
            String apiUrl = "https://sms_developer.zhenzikj.com";
            String  appId = "104840";
            String appSecret ="b2b54f22-0f0e-4247-86f3-d8d140937443";
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            Map<String,String > params=new HashMap<String,String>();
//           文字信息中不能出现“手机号”要换“号码”来表达。
            String info="您好，您的云朵空间已经注册成功，可以使用号码： "+user.getPhone()+"，或云朵账号："+user.getAccount()+"来进行登陆，密码为："+user.getPassword()+",祝您生活愉快，云朵空间，伴您成长每一天~ ";
//          String info="hello 这是测试发送短信";
            params.put("message",info);
            params.put("number",user.getPhone());
            try{
               String results = client.send(params);
               System.out.println("短信的发送已完成: "+results);

            }catch (Exception e){
                System.out.println("短信系统已经失效，请联系兰国海：14078085563");
            }

            return registerRsp;
        } else {
            registerRsp.setResult(2);
            return registerRsp;
        }
    }

    //更新用户的信息
    @Override
    public Integer updUserInfo(UpdUserInfoReq model) {
        if (model.getFile() == null) {
            Users user = CloneUtil.cloneObj(model, Users.class);
            usersMapper.updateByPrimaryKeySelective(user);
            return 1;
        }
        String filename = model.getFile().getOriginalFilename();
        String filelast = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID() + filelast;
        String filepath = "E:/temp-rainy/";
        File dest = new File(filepath + filename);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            model.getFile().transferTo(dest);
        } catch (IOException e) {
            System.out.println("传输过程异常！");
            e.printStackTrace();
        }
//        model.setAvatar(filepath+filename);
        Users user = CloneUtil.cloneObj(model, Users.class);
        user.setAvatar("/temp-rainy/" + filename);
        usersMapper.updateByPrimaryKeySelective(user);
//        System.out.println("更新成功了！");
        return 1;
    }

    /**
     * 获取用户信息
     *
     * @param userid
     * @return
     */
    @Override
    public FindUserInfoRsp findUserInfo(Integer userid) {
        Users users = usersMapper.selectByPrimaryKey(userid);
//        if(users.getAvatar().equals(null)){
////            users.setAvatar("../../images/兔子.jpg");
////        }
        FindUserInfoRsp userInfoRsq = CloneUtil.cloneObj(users, FindUserInfoRsp.class);
        return userInfoRsq;
    }

    @Override
    public StatisticsInfoRsp statisticsInfo(Integer account) {
//        等后期再开发
        return null;
    }

    /**
     * 查找好友用户
     *
     * @param info
     * @return
     */
    @Override
    public PageInfo<Users> findUserFriend(FindUserFriendReq info)
    {
        PageHelper.startPage(info.getPageNumber(),info.getPageSize());
        List<Users> list=usersMapper.findUserFriend(info.getInfo());
        PageInfo<Users> pageInfo=new PageInfo<Users>(list);
        return pageInfo;
    }
}
