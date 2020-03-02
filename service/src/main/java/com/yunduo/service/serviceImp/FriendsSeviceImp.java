package com.yunduo.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunduo.bean.AddFriendReq;
import com.yunduo.bean.FindFriendListReq;
import com.yunduo.dao.FriendsMapper;
import com.yunduo.entities.Friends;
import com.yunduo.entities.Users;
import com.yunduo.service.FriendsService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsSeviceImp  implements FriendsService {
    @Autowired
    FriendsMapper friendsMapper;

    /**
     * 获取好友数量
     * @param master_id
     * @return
     */
    @Override
    public Integer friendNumber(Integer master_id) {
        return   friendsMapper.findFriendNumber(master_id);
    }

    /**
     * 获取好友列表信息
     * @param model
     * @return
     */
    @Override
    public PageInfo<Users> findFriendList(FindFriendListReq model) {
        PageHelper.startPage(model.getPageNumber(),model.getPageSize());
        List<Users> list=friendsMapper.findFriendList(model.getAccount());
        PageInfo<Users> userlist=new PageInfo<Users>(CloneUtil.clonePage(list,Users.class));
        return userlist;
    }

    /**
     * 添加好友（单向的）
     * @param model
     * @return
     */
    @Override
    public Integer addFriend(AddFriendReq model) {
        Friends friends=new Friends();
        friends.setMaster_id(model.getMaster_id());
        friends.setFriend_id(model.getFriend_id());
        return friendsMapper.insert(friends);
    }
}
