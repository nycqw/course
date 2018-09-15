package com.eden.exception;

/**
 * 不支持的支付渠道异常
 */
public class UnsupportedPaymentChannelsException extends Exception {

    public UnsupportedPaymentChannelsException(String message) {
        super(message);
    }

}
