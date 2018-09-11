package com.eden.mapper;

import com.eden.model.EpayStatic;

public interface EpayStaticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EpayStatic record);

    int insertSelective(EpayStatic record);

    EpayStatic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EpayStatic record);

    int updateByPrimaryKey(EpayStatic record);
}