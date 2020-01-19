package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("左侧总览信息")
public class findOverViewReq {
    @ApiModelProperty("用户账号")
    private Integer account;

}
