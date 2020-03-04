package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("查找好友申请信息的响应")
@Data
public class FindFriendApplicationRsq {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("主人的id")
    private Integer master_id;
    @ApiModelProperty("申请者的id")
    private Integer friend_id;
    @ApiModelProperty("申请者的头像")
    private String avatar;
    @ApiModelProperty("申请者的昵称")
    private String name;
    @ApiModelProperty("申请者的个性签名")
    private String signature;
    @ApiModelProperty("申请时间")
    private String applicationtime;

}
