package com.eden.service.pay;

import com.eden.exception.UnsupportedPaymentChannelsException;

import java.math.BigDecimal;

/**
 * 支付接口
 */
public interface Payment {

    /**
     * 计算金额
     * @param channelId 支付渠道
     * @param goodsId 商品ID
     * @return
     */
    BigDecimal calRecharge(Integer channelId, Integer goodsId);

}
