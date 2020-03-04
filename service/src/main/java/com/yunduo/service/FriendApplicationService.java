package com.yunduo.service;

import com.yunduo.bean.FindFriendApplicationRsq;

import java.util.List;

public interface FriendApplicationService {
    public List<FindFriendApplicationRsq> findFriendApplication(Integer account);
}
