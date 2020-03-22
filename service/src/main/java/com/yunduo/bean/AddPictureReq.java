package com.yunduo.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddPictureReq {
    private MultipartFile file;
    private Integer master_id;
    private Integer ablum_id;
}
