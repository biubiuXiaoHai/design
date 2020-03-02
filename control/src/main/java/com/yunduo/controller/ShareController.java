package com.yunduo.controller;

import com.yunduo.bean.FindAllFriendShareRsp;
import com.yunduo.bean.ReportShareReq;
import com.yunduo.bean.ShareInfoRsp;
import com.yunduo.dao.ShareMapper;
import com.yunduo.entities.Share;
import com.yunduo.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "ShareController" ,description = "说说信息")
public class ShareController {
    @Autowired
    ShareService shareService;
    /**
     * 统计好友数量
     * 入：主id
     * 出：好友数量
     */

    /**说说页（主人发表）
     *
     * 添加说说
     */
    @PostMapping("reportShare")
    @ApiOperation("添加说说")
    public ShareInfoRsp reportShare(ReportShareReq model){
        return shareService.reportShare(model);
    }


    /**说说页（查看总的）
     *
     * 列出好友说说
     */
    @PostMapping("findAllFriendShare")
    @ApiOperation("列出好友说说")
    public List<FindAllFriendShareRsp> findAllFriendShare(Integer master_id){
       return  shareService.findAllFriendShare(master_id);

    }


}
