package com.eden.service.pay.impl;

import com.eden.service.pay.Payment;
import com.eden.service.pay.annotation.Pay;
import com.eden.utils.FieldAutowiredAware;
import java.math.BigDecimal;
import static com.eden.service.pay.constants.PayConstants.WX_PAY;

/**
 * 微信支付
 */
@Pay(WX_PAY)
public class WxPayment extends FieldAutowiredAware implements Payment {

    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        return new BigDecimal(200);
    }
}
