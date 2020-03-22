package com.yunduo.bean;

import lombok.Data;

@Data
public class AddAblumReq {
    private Integer master_id;

    private String ablum_title;
    private String ablum_description;
}
