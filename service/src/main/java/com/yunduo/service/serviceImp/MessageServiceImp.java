package com.yunduo.service.serviceImp;

import com.yunduo.bean.AddMessageReq;
import com.yunduo.bean.FindMessageRsp;
import com.yunduo.bean.UpdHostMessageReq;
import com.yunduo.dao.HostMessageMapper;
import com.yunduo.dao.MessageMapper;
import com.yunduo.dao.UsersMapper;
import com.yunduo.entities.HostMessage;
import com.yunduo.entities.Message;
import com.yunduo.entities.Users;
import com.yunduo.service.MessageService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    HostMessageMapper hostMessageMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UsersMapper usersMapper;

    /**
     * 更新主人寄语
     * @param model
     * @return
     */
    @Override
    public Integer updHostMessage(UpdHostMessageReq model) {
        HostMessage hostMessage=new HostMessage();
        hostMessage.setId(hostMessageMapper.selectByMasterId(model.getMaster_id()).getId());
        hostMessage.setMaster_id(model.getMaster_id());
        hostMessage.setMessage(model.getMessage());
        Date time=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String nowtime=simpleDateFormat.format(time);
        hostMessage.setLast_time(nowtime);
        return hostMessageMapper.updateByPrimaryKeySelective(hostMessage);
    }

    @Override
    public HostMessage findHostMessage(Integer master_id) {
       HostMessage hostinfo= hostMessageMapper.selectByMasterId(master_id);
        if(hostinfo==null){
            hostinfo=new HostMessage();
            hostinfo.setMaster_id(master_id);
            hostinfo.setMessage("主人在云里浪着，忙着照顾好友的空间，什么也没留下哦~");
            hostMessageMapper.insertSelective(hostinfo);
            return hostMessageMapper.selectByMasterId(master_id);
        }
        return hostinfo;
    }

    @Override
    public Integer addMessage(AddMessageReq model) {
        Message message=new Message();
        message.setMaster_id(model.getMaster_id());
        message.setFriend_id(model.getFriend_id());
        Users user=usersMapper.selectByPrimaryKey(model.getFriend_id());
        message.setFriend_name(user.getName());
        message.setFriend_avatar(user.getAvatar());
        message.setMessage(model.getMessage());
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String time=simpleDateFormat.format(date);
        message.setLast_time(time);

        return messageMapper.insertSelective(message);

    }

    @Override
    public List<FindMessageRsp> findMessage(Integer master_id) {
        List<Message> list=messageMapper.selectByMasterId(master_id);
        List<FindMessageRsp> result= CloneUtil.cloneList(list,FindMessageRsp.class);
        return result;
    }

    @Override
    public Integer delMessage(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }
}
