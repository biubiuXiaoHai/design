package com.yunduo.dao;

import com.yunduo.bean.AddFriendFailReq;
import com.yunduo.bean.AddFriendSuccessReq;
import com.yunduo.entities.FriendApplication;

import java.util.List;

public interface FriendApplicationMapper {
    List<FriendApplication> selectByFriendId(Integer friend_id);
    List<FriendApplication> findApplication(Integer account);
    Integer deleteByMasterIdAndFriendId(FriendApplication model);

    FriendApplication selectByMasterIdAndFriendId(AddFriendSuccessReq model);

    int deleteByPrimaryKey(Integer id);

    int insert(FriendApplication record);

    int insertSelective(FriendApplication record);

    FriendApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FriendApplication record);

    int updateByPrimaryKey(FriendApplication record);
}