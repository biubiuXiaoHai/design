package com.yunduo.bean;

import lombok.Data;

@Data
public class AddFriendSuccessReq {
    private Integer id;

    private Integer master_id;

    private Integer friend_id;


    private String add_time;
}
