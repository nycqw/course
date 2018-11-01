package com.eden.mapper;

import com.eden.model.EdenProduct;

public interface EdenProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(EdenProduct record);

    int insertSelective(EdenProduct record);

    EdenProduct selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(EdenProduct record);

    int updateByPrimaryKey(EdenProduct record);
}