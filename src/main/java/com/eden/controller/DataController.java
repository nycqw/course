package com.eden.controller;

import com.eden.model.EpayOrder;
import com.eden.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 18060757 on 2018/9/11.
 */
@Controller
public class DataController {

    @Resource
    private DataService dataService;

    @RequestMapping("/query")
    @ResponseBody
    public EpayOrder queryOrder(Long orderId) {
        EpayOrder epayOrder = dataService.queryOrder(orderId);
        return epayOrder;
    }
}
