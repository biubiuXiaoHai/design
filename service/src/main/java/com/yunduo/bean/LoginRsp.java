package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录响应")
public class LoginRsp {
    @ApiModelProperty("1.登录成功，2.登录失败（该账号不存在），3.登录失败（密码错误)")
    private Integer result;
    @ApiModelProperty("登录成功用户的id")
    private Integer account;
    @ApiModelProperty("登录成功用户的名字")
    private String name;
}
