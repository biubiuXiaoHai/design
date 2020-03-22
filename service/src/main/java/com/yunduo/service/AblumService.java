package com.yunduo.service;

import com.yunduo.bean.AddAblumReq;
import com.yunduo.bean.UpdAblumPageReq;
import com.yunduo.bean.UpdAblumReq;
import com.yunduo.entities.Ablum;

import java.util.List;

public interface AblumService {
    public Integer addAblum(AddAblumReq model);
    public List<Ablum> findAblum(Integer master_id);
    public Ablum findAblumByAblumId(Integer id);
    public Integer updAblum(UpdAblumReq model);
    public Integer updAblumPage(UpdAblumPageReq model);
    public Integer findAblumNumber(Integer ablum_id);
    public Integer delAblum(Integer id);
}
