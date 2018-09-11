package com.eden.mapper;

import com.eden.model.EpayOrder;

public interface EpayOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(EpayOrder record);

    int insertSelective(EpayOrder record);

    EpayOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(EpayOrder record);

    int updateByPrimaryKey(EpayOrder record);
}