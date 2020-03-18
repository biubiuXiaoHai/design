package com.yunduo.dao;

import com.yunduo.entities.HostMessage;

public interface HostMessageMapper {
    HostMessage selectByMasterId(Integer master_id);

    int deleteByPrimaryKey(Integer id);

    int insert(HostMessage record);

    int insertSelective(HostMessage record);

    HostMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HostMessage record);

    int updateByPrimaryKey(HostMessage record);
}