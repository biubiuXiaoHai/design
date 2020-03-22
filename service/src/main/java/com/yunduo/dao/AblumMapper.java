package com.yunduo.dao;

import com.yunduo.entities.Ablum;

import java.util.List;

public interface AblumMapper {
    List<Ablum> selectByMasterId(Integer master_id);
    int deleteByPrimaryKey(Integer id);

    int insert(Ablum record);

    int insertSelective(Ablum record);

    Ablum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ablum record);

    int updateByPrimaryKey(Ablum record);
}