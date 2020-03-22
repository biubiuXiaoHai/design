package com.yunduo.dao;

import com.yunduo.entities.PraisePower;

public interface PraisepowerMapper {
    PraisePower selectByShareIdAndPersonId(PraisePower model);

    int deleteByPrimaryKey(Integer id);

    int insert(PraisePower record);

    int insertSelective(PraisePower record);

    PraisePower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PraisePower record);

    int updateByPrimaryKey(PraisePower record);
}