package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "注册请求")
public class RegisterReq {
    @ApiModelProperty("昵称")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("电话")
    private String phone;

}
