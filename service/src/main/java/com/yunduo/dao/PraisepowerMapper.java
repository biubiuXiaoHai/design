package com.yunduo.dao;

import com.yunduo.entities.Praisepower;

public interface PraisepowerMapper {
    Praisepower selectByShareIdAndPersonId(Praisepower model);

    int deleteByPrimaryKey(Integer id);

    int insert(Praisepower record);

    int insertSelective(Praisepower record);

    Praisepower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Praisepower record);

    int updateByPrimaryKey(Praisepower record);
}