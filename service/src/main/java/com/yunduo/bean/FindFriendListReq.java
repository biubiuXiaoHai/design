package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "获取好友列表请求")
public class FindFriendListReq {
    private Integer account;
    private Integer pageSize;
    private Integer pageNumber;
}
