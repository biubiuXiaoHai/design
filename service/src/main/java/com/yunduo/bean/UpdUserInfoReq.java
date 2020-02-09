package com.yunduo.bean;

import lombok.Data;

@Data
public class UpdUserInfoReq {

    private String name;

    private String password;

    private String phone;

    private String avatar;

    private String sex;

    private Integer birthday;

    private Byte constellationsid;

    private String fondness;

    private String signature;

    private Byte vip_static;

    private Integer sum_date;

}
