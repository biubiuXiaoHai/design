package com.yunduo.dao;

import com.yunduo.entities.Users;

import java.util.List;

public interface UsersMapper {
    int selectByPhone(String phone);
    Users selectByPhoneAll(String phone);
    List<Users> findUserFriend(String info);

    int deleteByPrimaryKey(Integer account);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer account);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}