package com.yunduo.bean;

import io.swagger.annotations.ApiModelProperty;

public class AddFriendfailReq {
    @ApiModelProperty("主人的id")
    private Integer master_id;
    @ApiModelProperty("好友的id")
    private Integer friend_id;

}
