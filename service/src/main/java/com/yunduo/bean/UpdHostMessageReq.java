package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("添加主人寄语请求")
public class UpdHostMessageReq {
    private Integer master_id;
    private String message;
}
