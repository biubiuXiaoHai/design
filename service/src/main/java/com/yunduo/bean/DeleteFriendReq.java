package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("删除好友请求")
public class DeleteFriendReq {
    @ApiModelProperty("主人的id")
    private Integer master_id;
    @ApiModelProperty("被删除者的id")
    private Integer friend_id;
}
