package com.eden.service.pay.annotation;

import com.eden.exception.UnsupportedPaymentChannelsException;
import com.eden.service.pay.Payment;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import static com.eden.service.pay.constants.PayConstants.PAY_BASE_PACKAGE;

@Slf4j
public class PaymentFactory {

    private static PaymentFactory paymentFactory = new PaymentFactory();

    public static PaymentFactory getInstance() {
        return paymentFactory;
    }

    private static Map<Integer, String> paymentMap = new ConcurrentHashMap<>();

    static {
        Reflections reflections = new Reflections(PAY_BASE_PACKAGE);
        Set<Class<?>> paySet = reflections.getTypesAnnotatedWith(Pay.class);
        for (Class<?> payClazz : paySet) {
            Pay annotation = payClazz.getAnnotation(Pay.class);
            Integer channelId = annotation.value();
            paymentMap.put(channelId, payClazz.getCanonicalName());
        }
    }

    public Payment create(Integer channelId) throws UnsupportedPaymentChannelsException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!paymentMap.containsKey(channelId)) {
            throw new UnsupportedPaymentChannelsException(channelId.toString());
        }
        String payClazz = paymentMap.get(channelId);
        Class<?> aClass = Class.forName(payClazz);
        return (Payment) aClass.newInstance();
    }

}
