package com.eden.service.pay.impl;

import com.eden.exception.UnsupportedPaymentChannelsException;
import com.eden.service.pay.Payment;
import com.eden.service.pay.annotation.PaymentFactory;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class PaymentHandler implements Payment {

    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        PaymentFactory paymentFactory = PaymentFactory.getInstance();
        Payment payment = null;
        try {
            payment = paymentFactory.create(channelId);
        } catch (UnsupportedPaymentChannelsException e) {
            log.error("不支持的支付类型");
        } catch (Exception e) {
            log.error("系统异常！", e);
        }
        return payment.calRecharge(channelId, goodsId);
    }

}
