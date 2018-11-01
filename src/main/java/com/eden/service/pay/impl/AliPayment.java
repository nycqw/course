package com.eden.service.pay.impl;

import com.eden.mapper.EdenProductMapper;
import com.eden.model.EdenProduct;
import com.eden.service.pay.Payment;
import com.eden.service.pay.annotation.Pay;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static com.eden.service.pay.constants.PayConstants.ALI_PAY;

/**
 * 支付宝支付
 */
@Pay(ALI_PAY)
public class AliPayment implements Payment {

    @Resource
    private EdenProductMapper edenProductMapper;

    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        EdenProduct edenProduct = edenProductMapper.selectByPrimaryKey(String.valueOf(goodsId));
        if (edenProduct != null) {
            return new BigDecimal(edenProduct.getPrice());
        }
        return null;
    }
}
