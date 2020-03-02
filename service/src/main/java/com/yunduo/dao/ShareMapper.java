package com.yunduo.dao;

import com.yunduo.bean.FindAllFriendShareRsp;
import com.yunduo.entities.Share;

import java.util.List;

public interface ShareMapper {
    Share selectByMasteridAndTime(Integer master_id,String share_time);

    List<Share>findAllFriendShare(Integer master_id);


    int deleteByPrimaryKey(Integer id);

    int insert(Share record);

    int insertSelective(Share record);

    Share selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
}