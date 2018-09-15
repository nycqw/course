package com.eden.service.pay.constants;

/**
 * 支付渠道
 */
public interface PayConstants {

    // 微信支付
    int WX_PAY = 1;
    // 支付宝支付
    int ALI_PAY = 2;

    // 支付处理根路径
    String PAY_BASE_PACKAGE = "com.eden.service.pay.impl";

}
