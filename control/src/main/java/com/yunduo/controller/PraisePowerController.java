package com.yunduo.controller;

import com.yunduo.bean.AddPraiseInfoReq;
import com.yunduo.service.PraisePowerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("praisePower")
@Api(value = "praisePowerController",description = "点赞功能")
public class PraisePowerController {
    @Autowired
    PraisePowerService praisePowerService;
    @PostMapping("addPraiseInfo")
    public Integer addPraiseInfo(AddPraiseInfoReq model){
        return praisePowerService.addPraiseInfo(model);
    }

}
