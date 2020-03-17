package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("点赞请求")
public class AddPraiseInfoReq {
    @ApiModelProperty("说说的id")
    private Integer share_id;
    @ApiModelProperty("点赞者的id")
    private Integer person_id;
    @ApiModelProperty("点赞者的名字")
    private String person_name;
}
