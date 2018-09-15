package com.eden.controller;

import com.eden.service.pay.impl.PaymentHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class PaymentController {

    @RequestMapping("/pay")
    @ResponseBody
    public BigDecimal calCharge(Integer channelId, Integer goodsId) {
        PaymentHandler handler = new PaymentHandler();
        return handler.calRecharge(channelId, goodsId);
    }
}
