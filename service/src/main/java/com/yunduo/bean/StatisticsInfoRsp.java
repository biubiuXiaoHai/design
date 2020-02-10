package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "统计信息响应")
public class StatisticsInfoRsp {
    private Integer share_number;
    private Integer message_number;
    private Integer photo_number;
}
