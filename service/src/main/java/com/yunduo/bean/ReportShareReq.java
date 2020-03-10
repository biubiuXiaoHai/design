package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@ApiModel("发表说说请求")
public class ReportShareReq {
    @ApiModelProperty("用户主人的id")
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
    @ApiModelProperty("文字信息")
    private String words;

}
