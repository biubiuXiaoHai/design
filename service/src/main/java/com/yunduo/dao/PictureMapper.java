package com.yunduo.dao;

import com.yunduo.entities.Picture;
import io.swagger.models.auth.In;

import java.util.List;

public interface PictureMapper {
    Integer selectSumByMasterId(Integer master_id);
    List<Picture> selectByMasterId(Integer master_id);
    Integer deleteByAblumId(Integer ablum_id);
    Integer findAblumNumber(Integer ablum_id);
    List<Picture> selectByAblumId(Integer ablum_id);

    int deleteByPrimaryKey(Integer picture_id);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer picture_id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}