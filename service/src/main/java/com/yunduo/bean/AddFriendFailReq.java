package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("拒绝添加好友的响应")
public class AddFriendFailReq {
    @ApiModelProperty("主人的id")
    private Integer master_id;
    @ApiModelProperty("好友的id")
    private Integer friend_id;

}
