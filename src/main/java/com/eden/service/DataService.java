package com.eden.service;

import com.eden.mapper.EpayOrderMapper;
import com.eden.model.EpayOrder;
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

        return epayOrderMapper.selectByPrimaryKey(orderId);
    }

    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};
        List<String> list = Arrays.asList(strings);
    }

}
