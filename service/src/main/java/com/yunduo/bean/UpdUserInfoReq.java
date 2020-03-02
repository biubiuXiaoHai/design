package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
@ApiModel("修改用户信息请求")
public class UpdUserInfoReq {
    @ApiModelProperty("账号")
    private Integer account;
//    头像图片
    @ApiModelProperty("账号")
    private MultipartFile  file;
    @ApiModelProperty("昵称")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("生日")
    private String  birthday;

//    private Byte constellationsid;
    @ApiModelProperty("爱好")
    private String fondness;
    @ApiModelProperty("个性签名")
    private String signature;


}
