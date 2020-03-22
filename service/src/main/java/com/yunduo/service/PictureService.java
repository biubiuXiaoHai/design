package com.yunduo.service;

import com.yunduo.bean.AddPictureReq;
import com.yunduo.entities.Picture;

import java.util.List;

public interface PictureService {
    public Integer addPicture(AddPictureReq model);
    public List<Picture> findPictureByAblumId(Integer ablum_id);
    public Integer delPicture(Integer picture_id);
    public List<Picture> findAllPicture(Integer master_id);
}
