package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("总览信息响应")
public class findOverViewRsp {
    @ApiModelProperty("留言数量")
    private int message;
    @ApiModelProperty("说说数量")
    private int share;
    @ApiModelProperty("照片数量")
    private int photo;

}
