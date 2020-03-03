package com.yunduo.dao;

import com.yunduo.bean.DeleteFriendReq;
import com.yunduo.entities.Friends;
import com.yunduo.entities.Users;

import java.util.List;

public interface FriendsMapper {
    Integer deleteByMasterIdAndFriendId(DeleteFriendReq model);
    Integer updBecomeFriendTime(Friends model);
    Integer findFriendNumber(Integer master_id);
    List<Users> findFriendList(Integer account );

    int deleteByPrimaryKey(Integer id);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
}