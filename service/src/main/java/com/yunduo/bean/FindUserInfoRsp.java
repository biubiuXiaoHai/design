package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查找用户信息响应")
public class FindUserInfoRsp {
    @ApiModelProperty("账号")
    private Integer account;
    @ApiModelProperty("昵称")
    private String name;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("生日")
    private Integer birthday;
    @ApiModelProperty("爱好")
    private String fondness;
    @ApiModelProperty("个性签名")
    private String signature;
    @ApiModelProperty("vip状态")
    private Byte vip_static;
    @ApiModelProperty("连续登录日期")
    private Integer sum_date;
}
