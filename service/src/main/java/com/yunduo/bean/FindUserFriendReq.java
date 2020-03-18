package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("搜索好友信息请求")
public class FindUserFriendReq {
    private  String info;
    private int pageNumber;
    private int pageSize;
}
