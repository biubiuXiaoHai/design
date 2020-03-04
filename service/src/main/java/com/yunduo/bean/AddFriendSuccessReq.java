package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("添加好友成功请求")
public class AddFriendSuccessReq {
//    private Integer id;
    @ApiModelProperty("主人的id")
    private Integer master_id;
    @ApiModelProperty("好友的id")
    private Integer friend_id;

    private String add_time;
}
