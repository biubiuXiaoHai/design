package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AddFriendReq {
    @ApiModelProperty("主人的id")
    private Integer master_id;
    @ApiModelProperty("好友的id")
    private Integer friend_id;
}
