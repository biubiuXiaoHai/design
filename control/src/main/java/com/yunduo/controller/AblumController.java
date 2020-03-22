package com.yunduo.controller;

import com.yunduo.bean.AddAblumReq;
import com.yunduo.bean.UpdAblumPageReq;
import com.yunduo.bean.UpdAblumReq;
import com.yunduo.entities.Ablum;
import com.yunduo.service.AblumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "AblumController", description = "相册管理")
@RestController
@RequestMapping("ablum")
public class AblumController {
    @Autowired
    AblumService ablumService;

    @PostMapping("addAblum")
    @ApiOperation("添加一个相册封面信息")
    public Integer addAblum(AddAblumReq model) {
        return ablumService.addAblum(model);
    }

    @PostMapping("findAblumByMasterId")
    @ApiOperation("通过主人id获取相册封面信息")
    public List<Ablum> findAblum(Integer master_id) {
        return ablumService.findAblum(master_id);
    }

    @PostMapping("findAblumNumber")
    @ApiOperation("获取该相册中的照片数量")
    public Integer findAblumNumber(Integer ablum_id){
        return ablumService.findAblumNumber(ablum_id);
    }
    @PostMapping("findAblumByAblumId")
    @ApiOperation("通过相册ID获取相册封面信息")
    public Ablum findAblumByAblumId(Integer id) {
        return ablumService.findAblumByAblumId(id);
    }

    @PostMapping("updAblum")
    @ApiOperation("更新相册封面")
    public Integer updAblum(UpdAblumReq model) {
        return ablumService.updAblum(model);
    }

    @PostMapping("updAblumPage")
    @ApiOperation("更新相册封面图片")
    public Integer updAblumPage(UpdAblumPageReq model) {
        return ablumService.updAblumPage(model);
    }

    @PostMapping("delAblum")
    @ApiOperation("删除相册")
    public Integer delAblum(Integer id){
       return ablumService.delAblum(id);
    }

}
