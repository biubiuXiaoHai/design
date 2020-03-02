package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "获取好友列表请求")
public class FindFriendListReq {
    @ApiModelProperty("账号")
    private Integer account;
    private Integer pageSize;
    private Integer pageNumber;
}
