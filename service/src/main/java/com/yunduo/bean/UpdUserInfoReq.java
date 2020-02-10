package com.yunduo.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class UpdUserInfoReq {
    private Integer account;
//    头像图片
    private MultipartFile  file;

    private String name;

    private String password;

    private String phone;

    private String avatar;

    private String sex;

    private String  birthday;

//    private Byte constellationsid;

    private String fondness;

    private String signature;


}
