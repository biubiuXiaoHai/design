package com.yunduo.service;

import com.yunduo.bean.FindMasterShareRsq;
import com.yunduo.bean.ReportShareReq;
import com.yunduo.entities.Share;
//import com.yunduo.bean.ShareInfoRsp;

import java.util.List;

public interface ShareService {
    public Integer delShareInfo(Integer id);
    public Integer reportShare(ReportShareReq model);
    public List<FindMasterShareRsq> findMasterShare(Integer master_id);
    public List<Share>findFriendShare(Integer master_id);
}
