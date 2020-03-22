package com.yunduo.service.serviceImp;

import com.yunduo.bean.AddPictureReq;
import com.yunduo.dao.AblumMapper;
import com.yunduo.dao.PictureMapper;
import com.yunduo.entities.Ablum;
import com.yunduo.entities.Picture;
import com.yunduo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PictureServiceImp implements PictureService {
    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    AblumMapper ablumMapper;
    @Override
    public Integer addPicture(AddPictureReq model) {
        MultipartFile file=model.getFile();
        String filename=file.getOriginalFilename();
        String namelast=filename.substring(filename.lastIndexOf("."));
        String newname= UUID.randomUUID()+namelast;
        String filepath="E:/temp-rainy/";
        File dest=new File(filepath+newname);
        try{
            file.transferTo(dest);
        }catch (Exception e){
            System.out.println("上传图片异常");
        }
        Picture picture=new Picture();
        picture.setAblum_id(model.getAblum_id());
        picture.setMaster_id(model.getMaster_id());
        Date data=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String time=simpleDateFormat.format(data);
        picture.setPush_time(time);
        picture.setUrl("http://127.0.0.1:8090/temp-rainy/"+newname);
        //相册中的数量加 1
        Ablum ablum=ablumMapper.selectByPrimaryKey(model.getAblum_id());
        ablum.setPicture_number(ablum.getPicture_number()+1);
        ablumMapper.updateByPrimaryKeySelective(ablum);
        return pictureMapper.insert(picture);
    }

    @Override
    public List<Picture> findPictureByAblumId(Integer ablum_id) {
        return pictureMapper.selectByAblumId(ablum_id);
    }

    @Override
    public Integer delPicture(Integer picture_id) {
        //相册总数减 1
        Picture picture=pictureMapper.selectByPrimaryKey(picture_id);
        Ablum ablum=ablumMapper.selectByPrimaryKey(picture.getAblum_id());
        ablum.setPicture_number(ablum.getPicture_number()-1);
        ablumMapper.updateByPrimaryKeySelective(ablum);
        return pictureMapper.deleteByPrimaryKey(picture_id);
    }

    @Override
    public List<Picture> findAllPicture(Integer master_id) {
        return  pictureMapper.selectByMasterId(master_id);
    }
}
