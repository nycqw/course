package com.eden.service;

import com.eden.mapper.EpayOrderMapper;
import com.eden.model.EpayOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 18060757 on 2018/9/11.
 */
@Service
public class DataService {

    @Autowired
    private EpayOrderMapper epayOrderMapper;

    public EpayOrder queryOrder(Long orderId) {
        return epayOrderMapper.selectByPrimaryKey(orderId);
    }
}
