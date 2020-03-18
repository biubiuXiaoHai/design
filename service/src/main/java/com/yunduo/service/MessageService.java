package com.yunduo.service;

import com.yunduo.bean.AddMessageReq;
import com.yunduo.bean.FindMessageRsp;
import com.yunduo.bean.UpdHostMessageReq;
import com.yunduo.entities.HostMessage;

import java.util.List;

public interface MessageService {
    public Integer updHostMessage(UpdHostMessageReq model);
    public HostMessage findHostMessage(Integer master_id);
    public Integer addMessage(AddMessageReq model);
    public List<FindMessageRsp>findMessage(Integer master_id);
    public Integer delMessage(Integer id);
}
