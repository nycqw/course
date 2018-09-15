package com.eden.mapper;

import com.eden.model.TfFUser;

public interface TfFUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(TfFUser record);

    int insertSelective(TfFUser record);

    TfFUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TfFUser record);

    int updateByPrimaryKey(TfFUser record);
}