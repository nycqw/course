package com.eden.controller;

import com.eden.service.pay.annotation.PaymentHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Controller
public class PaymentController {

    @Resource
    PaymentHandler paymentHandler;

    @RequestMapping("/pay")
    @ResponseBody
    public BigDecimal calCharge(Integer channelId, Integer goodsId) {
        return paymentHandler.calRecharge(channelId, goodsId);
    }
}
