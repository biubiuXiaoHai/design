package com.yunduo.dao;

import com.yunduo.entities.Users;

public interface UsersMapper {
    int selectByPhone(String phone);
    Users selectByPhoneAll(String phone);

    int deleteByPrimaryKey(Integer account);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer account);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}