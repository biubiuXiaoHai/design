package com.yunduo.service;

import com.yunduo.bean.FindAllFriendShareRsp;
import com.yunduo.bean.ReportShareReq;
import com.yunduo.bean.ShareInfoRsp;
import com.yunduo.entities.Share;

import java.util.List;

public interface ShareService {
    public ShareInfoRsp reportShare(ReportShareReq model);
    public List<FindAllFriendShareRsp> findAllFriendShare(Integer master_id);
}
