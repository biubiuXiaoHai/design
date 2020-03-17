package com.yunduo.bean;

import com.yunduo.entities.Praisepower;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("获取相关的说说信息")
public class FindMasterShareRsq {
    private Integer id;

    private String master_img;

    private Integer master_id;
    private String master_name;

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

    private List<String> person_name;

}
