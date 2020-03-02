package com.yunduo.bean;

import lombok.Data;

@Data
public class ShareInfoRsp {
    private Integer id;

    private String share_time;

    private String picture1;

    private String picture2;

    private String picture3;

    private String picture4;

    private String picture5;

    private String picture6;

    private String picture7;

    private String picture8;

    private String picture9;

    private String words;

    private Integer saw_time;
    //用户信息
    private Integer account;
    private String avatar;
    private String name;
}
