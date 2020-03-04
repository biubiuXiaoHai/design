package com.yunduo.service.serviceImp;

import com.yunduo.bean.FindFriendApplicationRsq;
import com.yunduo.dao.FriendApplicationMapper;
import com.yunduo.entities.FriendApplication;
import com.yunduo.service.FriendApplicationService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendApplicationServiceImp implements FriendApplicationService {
    @Autowired
    FriendApplicationMapper friendApplicationMapper;
    @Override
    public List<FindFriendApplicationRsq> findFriendApplication(Integer account) {
        List<FriendApplication> list=friendApplicationMapper.findApplication(account);
        List<FindFriendApplicationRsq> rsqlist= CloneUtil.cloneList(list,FindFriendApplicationRsq.class);
        return rsqlist;
    }
}
