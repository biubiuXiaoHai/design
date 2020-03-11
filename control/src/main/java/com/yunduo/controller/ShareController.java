package com.yunduo.controller;


import com.yunduo.bean.FindMasterShareRsq;
import com.yunduo.bean.ReportShareReq;
//import com.yunduo.bean.ShareInfoRsp;
import com.yunduo.entities.Share;
import com.yunduo.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "ShareController" ,description = "说说信息")
@RequestMapping("share")
public class ShareController {
    @Autowired
    ShareService shareService;

    /**说说页（主人发表）
     *
     * 添加说说
     */
    @PostMapping("reportShare")
    @ApiOperation("发表说说")
    public Integer reportShare(ReportShareReq model){
        return shareService.reportShare(model);
    }
//    @PostMapping("findMasterShare")
//    @ApiOperation("获取个人已经发表的说说")
//    public List<FindAllFriendShareRsp> findMasterShare

    /**个人说说页
     *
     * 列出主人的说说
     */
    @PostMapping("findMasterShare")
    @ApiOperation("获取主人自己的说说")
    public List<FindMasterShareRsq> findMasterShare(Integer master_id){
       return  shareService.findMasterShare(master_id);
    }

    /**
     * 个人的说说页
     * @param id
     * @return
     */
    @PostMapping("delShareInfo")
    @ApiOperation("删除一条说说")
    public Integer delShareInfo(Integer id){
        return shareService.delShareInfo(id);
    }
    /**
     * 好友动态中的：
     */
    @PostMapping("findFriendShare")
    @ApiOperation("获取好友的说说信息")
    public List<Share>findFriendShare(Integer master_id){
       return shareService.findFriendShare(master_id);
    }
    /**
    * 预览头像的功能
    * */


}
