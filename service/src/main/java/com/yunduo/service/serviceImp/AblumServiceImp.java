package com.yunduo.service.serviceImp;

import com.yunduo.bean.AddAblumReq;
import com.yunduo.bean.UpdAblumPageReq;
import com.yunduo.bean.UpdAblumReq;
import com.yunduo.dao.AblumMapper;
import com.yunduo.dao.PictureMapper;
import com.yunduo.entities.Ablum;
import com.yunduo.entities.Picture;
import com.yunduo.service.AblumService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AblumServiceImp implements AblumService {
    @Autowired
    AblumMapper ablumMapper;
    @Autowired
    PictureMapper pictureMapper;

    @Override
    public Integer addAblum(AddAblumReq model) {
        Ablum ablum= CloneUtil.cloneObj(model,Ablum.class);
        return  ablumMapper.insertSelective(ablum);
    }

    @Override
    public List<Ablum> findAblum(Integer master_id) {
        return ablumMapper.selectByMasterId(master_id);
    }

    @Override
    public Ablum findAblumByAblumId(Integer id) {
        return ablumMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updAblum(UpdAblumReq model) {
        Ablum ablum=CloneUtil.cloneObj(model,Ablum.class);
        return ablumMapper.updateByPrimaryKeySelective(ablum);
    }

    @Override
    public Integer updAblumPage(UpdAblumPageReq model) {
        Picture picture=pictureMapper.selectByPrimaryKey(model.getPicture_id());
        Ablum ablum=ablumMapper.selectByPrimaryKey(model.getAblum_id());
        ablum.setAblum_head(picture.getUrl());
        return ablumMapper.updateByPrimaryKeySelective(ablum);
    }

    @Override
    public Integer findAblumNumber(Integer ablum_id) {
        return pictureMapper.findAblumNumber(ablum_id);
    }

    @Override
    public Integer delAblum(Integer id) {
        ablumMapper.deleteByPrimaryKey(id);
        pictureMapper.deleteByAblumId(id);
        return 1;
    }
}
