package com.yunduo.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Data
public class ReportShareReq {
    private Integer master_id;

    private MultipartFile picture1;

    private MultipartFile picture2;

    private MultipartFile picture3;

    private MultipartFile picture4;

    private MultipartFile picture5;

    private MultipartFile picture6;

    private MultipartFile picture7;

    private MultipartFile picture8;

    private MultipartFile picture9;

    private String words;

}
