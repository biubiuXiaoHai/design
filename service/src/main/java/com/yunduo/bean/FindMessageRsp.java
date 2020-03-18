package com.yunduo.bean;

import lombok.Data;

@Data
public class FindMessageRsp {
    private Integer id;

    private Integer master_id;

    private Integer friend_id;

    private String friend_avatar;

    private String friend_name;

    private String message;

    private String last_time;
}
