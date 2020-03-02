package com.yunduo.dao;

import com.yunduo.bean.AddFriendSuccessReq;
import com.yunduo.entities.FriendApplication;
import com.yunduo.entities.Friends;

public interface FriendApplicationMapper {
    Integer updApplyInfoState(Friends friends);

    FriendApplication selectByMasterIdAndFriendId(AddFriendSuccessReq model);

    int deleteByPrimaryKey(Integer id);

    int insert(FriendApplication record);

    int insertSelective(FriendApplication record);

    FriendApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FriendApplication record);

    int updateByPrimaryKey(FriendApplication record);
}