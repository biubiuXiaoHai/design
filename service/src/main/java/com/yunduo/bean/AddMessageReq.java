package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("添加留言请求")
public class AddMessageReq {
    private Integer master_id;
    private Integer friend_id;
    private String  message;
}
