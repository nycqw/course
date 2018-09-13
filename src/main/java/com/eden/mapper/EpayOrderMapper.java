package com.eden.mapper;

import com.eden.model.EpayOrder;

import java.util.List;

public interface EpayOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(EpayOrder record);

    int insertSelective(EpayOrder record);

    EpayOrder selectByPrimaryKey(Long orderId);

    /**
     * 声明为List返回的话返回结果将自动封装进List中
     * @return
     */
    List<EpayOrder> selectEpayOrder();

    int updateByPrimaryKeySelective(EpayOrder record);

    int updateByPrimaryKey(EpayOrder record);
}