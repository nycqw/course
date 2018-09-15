package com.eden.mapper;

import com.eden.model.EdenProduct;

public interface EdenProductMapper {
    int deleteByPrimaryKey(Long goodId);

    int insert(EdenProduct record);

    int insertSelective(EdenProduct record);

    EdenProduct selectByPrimaryKey(Long goodId);

    int updateByPrimaryKeySelective(EdenProduct record);

    int updateByPrimaryKey(EdenProduct record);
}