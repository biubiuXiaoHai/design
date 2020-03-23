package com.yunduo.dao;

import com.yunduo.entities.Message;

import java.util.List;

public interface MessageMapper {
    List<Message> selectByFriendId(Integer friend_id);
    Integer selectSumByMasterId(Integer master_id);
    List<Message>selectByMasterId(Integer master_id);
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}