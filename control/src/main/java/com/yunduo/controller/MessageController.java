package com.yunduo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
@Api(value = "messageController" ,description = "留言板信息")

public class MessageController {
    @PostMapping("findMessage")
    public  String findMessage(String  model){
        return null;
    }
}
