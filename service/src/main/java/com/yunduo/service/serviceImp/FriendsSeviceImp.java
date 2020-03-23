package com.yunduo.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunduo.bean.*;
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
        //如果自己的好友列表已经有该好友
        if(friendsMapper.findByMasterIdAndFriendId(model)!=0){
            //则在自己的好友列表中不重复添加
        }else {
            //单方面将对方加为好友
            Friends friends = new Friends();
            friends.setMaster_id(model.getMaster_id());
            friends.setFriend_id(model.getFriend_id());
            friendsMapper.insertSelective(friends);
        }
        if(model.getMaster_id().equals(model.getFriend_id())){
            //如果添加的是自己，则不要创建申请信息了。
            return 1;
        }
        //如果双方已经互相成为了好友
        if(friendsMapper.selectByMasterIdAndFriendId(model.getFriend_id(),model.getMaster_id())!=0){
            return 1;
        }
        //给对方创建一条好友请求信息
        FriendApplication friendApplication=new FriendApplication();
        friendApplication.setMaster_id(model.getFriend_id());
        friendApplication.setFriend_id(model.getMaster_id());
        Users user=usersMapper.selectByPrimaryKey(model.getFriend_id());
        friendApplication.setAvatar(user.getAvatar());
        friendApplication.setName(user.getName());
        friendApplication.setSignature(user.getSignature());
        Date  date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String time =simpleDateFormat.format(date);
        friendApplication.setApplicationtime(time);
        friendApplicationMapper.insertSelective(friendApplication);
        return 1;
    }

    @Override
    public Integer addFriendSuccess(AddFriendSuccessReq model) {
        Friends friend=CloneUtil.cloneObj(model,Friends.class);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String time=simpleDateFormat.format(date);
        friend.setAdd_time(time);
        //更新双方成为好友的时间
            friendsMapper.insertSelective(friend);
            friendsMapper.updBecomeFriendTime(friend);
        //删除申请记录
        FriendApplication delete=new FriendApplication();
        delete.setMaster_id(model.getMaster_id());
        delete.setFriend_id(model.getFriend_id());
        friendApplicationMapper.deleteByMasterIdAndFriendId(delete);
        return 1;
    }

    @Override
    public Integer addFriendFail(AddFriendFailReq model) {
        //删除申请记录
        FriendApplication delete=new FriendApplication();
        delete.setMaster_id(model.getMaster_id());
        delete.setFriend_id(model.getFriend_id());
        friendApplicationMapper.deleteByMasterIdAndFriendId(delete);
        return 1;
    }

    @Override
    public Integer deleteFriend(DeleteFriendReq model) {
        friendsMapper.deleteByMasterIdAndFriendId(model);
        return null;
    }
}
