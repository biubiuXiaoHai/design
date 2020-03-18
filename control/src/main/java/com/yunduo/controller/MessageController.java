package com.yunduo.controller;

import com.yunduo.bean.AddMessageReq;
import com.yunduo.bean.FindMessageRsp;
import com.yunduo.bean.UpdHostMessageReq;
import com.yunduo.entities.HostMessage;
import com.yunduo.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("message")
@Api(value = "messageController" ,description = "留言板信息")
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("addMessage")
    @ApiOperation("添加留言记录")
    public  Integer addMessage(AddMessageReq model){
         return  messageService.addMessage(model);
    }
    @PostMapping("findMessage")
    @ApiOperation("查询留言信息")
    public List<FindMessageRsp>findMessage(Integer master_id){
        return  messageService.findMessage(master_id);
    }
    @PostMapping("delMessage")
    @ApiOperation("删除留言信息")
    public Integer delMessage(Integer id){
        return messageService.delMessage(id);
    }

    @PostMapping("findHostMessage")
    @ApiOperation("查找主人寄语")
    public HostMessage findHostMessage(Integer master_id){
      return   messageService.findHostMessage(master_id);
    }
    @PostMapping("updHostMessage")
    @ApiOperation("更新主人寄语")
    public Integer updHostMessage(UpdHostMessageReq model){
        return    messageService.updHostMessage(model);
    }

}
