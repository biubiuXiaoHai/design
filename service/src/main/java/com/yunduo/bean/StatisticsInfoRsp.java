package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "统计信息响应")
public class StatisticsInfoRsp {
    @ApiModelProperty("说说数量")
    private Integer share_number;
    @ApiModelProperty("留言数量")
    private Integer message_number;
    @ApiModelProperty("照片数量")
    private Integer photo_number;
}
