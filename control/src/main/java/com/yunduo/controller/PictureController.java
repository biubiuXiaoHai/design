package com.yunduo.controller;

import com.yunduo.bean.AddPictureReq;
import com.yunduo.entities.Picture;
import com.yunduo.service.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "pictureController" ,description = "照片管理")
@RequestMapping("picture")
public class PictureController {

    @Autowired
    PictureService pictureService;
    @ApiOperation("添加照片")
    @PostMapping("addPicture")
    public Integer addPicture(AddPictureReq model){
      return   pictureService.addPicture(model);
    }
    @ApiOperation("通过相册ID获取照片")
    @PostMapping("findPictureByAblumId")
    public List<Picture> findPictureByAblumId(Integer ablum_id){
       return pictureService.findPictureByAblumId(ablum_id);
    }
    @PostMapping("delPicture")
    @ApiOperation("删除照片")
    public Integer delPicture(Integer picture_id){
      return   pictureService.delPicture(picture_id);
    }

    @PostMapping("findAllPicture")
    @ApiOperation("获取所有的个人照片")
    public List<Picture> findAllPicture(Integer master_id){
        return  pictureService.findAllPicture(master_id);
    }
}
