package com.eden.service.pay.impl;

import com.eden.mapper.EdenProductMapper;
import com.eden.model.EdenProduct;
import com.eden.service.pay.Payment;
import com.eden.service.pay.annotation.Pay;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static com.eden.service.pay.constants.PayConstants.SUNING_PAY;

/**
 * 支付宝支付
 */
@Pay(SUNING_PAY)
public class SnPayment implements Payment {

    @Resource
    private EdenProductMapper edenProductMapper;

    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        EdenProduct edenProduct = edenProductMapper.selectByPrimaryKey(Long.valueOf(goodsId));
        if (edenProduct != null) {
            return new BigDecimal(edenProduct.getFee());
        }
        return null;
    }
}
