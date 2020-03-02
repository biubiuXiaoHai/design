package com.yunduo.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunduo.bean.AddFriendReq;
import com.yunduo.bean.AddFriendSuccessReq;
import com.yunduo.bean.FindFriendListReq;
import com.yunduo.dao.FriendApplicationMapper;
import com.yunduo.dao.FriendsMapper;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.FriendApplication;
import com.yunduo.entities.Friends;
import com.yunduo.entities.Users;
import com.yunduo.service.FriendsService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FriendsSeviceImp  implements FriendsService {
    @Autowired
    FriendsMapper friendsMapper;
    @Autowired
    FriendApplicationMapper friendApplicationMapper;
    @Autowired
    UsersMapper usersMapper;
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
        //单方面将对方加为好友
        friends.setMaster_id(model.getMaster_id());
        friends.setFriend_id(model.getFriend_id());
        friendsMapper.insertSelective(friends);
        //给对方创建一条好友请求信息
        FriendApplication friendApplication=new FriendApplication();
        friendApplication.setMaster_id(model.getFriend_id());
        friendApplication.setFriend_id(model.getMaster_id());
        Users user=usersMapper.selectByPrimaryKey(model.getFriend_id());
        friendApplication.setAvatar(user.getAvatar());
        Date  date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年mm月dd日 hh时MM分ss秒");
        String time =simpleDateFormat.format(date);
        friendApplication.setApplicationtime(time);
        friendApplicationMapper.insertSelective(friendApplication);
        return 1;
    }

    @Override
    public Integer addFriendSuccess(AddFriendSuccessReq model) {
        Friends friend=CloneUtil.cloneObj(model,Friends.class);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy年mm月dd日 hh时MM分ss秒");
        String time=simpleDateFormat.format(date);
        friend.setAdd_time(time);
        //更新双方成为好友的时间
        friendsMapper.insertSelective(friend);
        friendsMapper.updBecomeFriendTime(friend);

        friendApplicationMapper.updApplyInfoState(friend);

        return null;
    }
}
