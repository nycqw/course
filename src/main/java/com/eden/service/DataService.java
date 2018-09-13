package com.eden.service;

import com.eden.mapper.EpayOrderMapper;
import com.eden.model.EpayOrder;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 18060757 on 2018/9/11.
 */
@Service
@Slf4j
public class DataService {

    @Autowired
    private EpayOrderMapper epayOrderMapper;

    public EpayOrder queryOrder(Long orderId) {
        log.info(orderId.toString());

        PageHelper.startPage(1,10);
        return epayOrderMapper.selectByPrimaryKey(orderId);
    }

    public List<EpayOrder> queryAll() {
        // 设置PageNum、PageSize
        PageHelper.startPage(1,2);
        // 当前list 会被自动封装进Page，不要直接return 查询语句
        List<EpayOrder> list = epayOrderMapper.selectEpayOrder();
        return list;
    }

}
