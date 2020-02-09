package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "注册结果响应")
public class RegisterRsq {
    @ApiModelProperty("1.注册成功,2.注册失败（手机号已经被注册）")
    private Integer result;
    @ApiModelProperty("云朵账号")
    private Integer account;
    @ApiModelProperty("登录密码")
    private String password;


}
