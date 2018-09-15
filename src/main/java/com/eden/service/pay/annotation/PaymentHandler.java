package com.eden.service.pay.annotation;

import com.eden.exception.UnsupportedPaymentChannelsException;
import com.eden.service.pay.Payment;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
@Component
@Slf4j
public class PaymentHandler implements Payment, ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static Map<Integer, String> paymentMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // 设置支付渠道与支付处理类之间的映射关系
    static {
        Reflections reflections = new Reflections();
        Set<Class<?>> paySet = reflections.getTypesAnnotatedWith(Pay.class);
        for (Class<?> payClazz : paySet) {
            Pay annotation = payClazz.getAnnotation(Pay.class);
            Integer channelId = annotation.value();
            paymentMap.put(channelId, payClazz.getCanonicalName());
        }
    }

    /**
     * 根据支付渠道调用具体支付处理类
     * @param channelId 支付渠道
     * @param goodsId   商品ID
     * @return
     */
    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        Payment payment = null;
        try {
            payment = create(channelId);
        } catch (UnsupportedPaymentChannelsException e) {
            log.error("不支持的支付类型");
        } catch (Exception e) {
            log.error("系统异常！", e);
        }
        return payment.calRecharge(channelId, goodsId);
    }

    /**
     * 实例化支付处理类
     * @param channelId 支付渠道
     * @return
     * @throws UnsupportedPaymentChannelsException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Payment create(Integer channelId) throws UnsupportedPaymentChannelsException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!paymentMap.containsKey(channelId)) {
            throw new UnsupportedPaymentChannelsException(channelId.toString());
        }
        String payClazzName = paymentMap.get(channelId);
        Class<?> payClazz = Class.forName(payClazzName);
        Payment payment = (Payment) payClazz.newInstance();
        initAutowiredField(payClazz, payment);
        return payment;
    }

    /**
     *  初始化自动装配的字段
     * @param payClazz
     * @param payment
     */
    private void initAutowiredField(Class<?> payClazz, Payment payment) {
        Field[] fields = payClazz.getDeclaredFields();
        for (Field field : fields) {
            Resource resource = field.getAnnotation(Resource.class);
            Autowired autowired = field.getAnnotation(Autowired.class);
            if (resource == null && autowired == null) {
                break;
            }
            String simpleName = field.getType().getSimpleName();
            String beanName = toLowerCaseFirstLetter(simpleName);

            // 从IOC容器中获取到这些字段的bean对象并进行赋值
            Object bean = applicationContext.getBean(beanName);
            field.setAccessible(true);
            try {
                field.set(payment, bean);
            } catch (IllegalAccessException e) {
                log.error("字段设置失败", e);
            }
        }
    }

    /**
     * 获取bean名称
     * @param name
     * @return
     */
    private String toLowerCaseFirstLetter(String name) {
        char firstLetter = Character.toLowerCase(name.charAt(0));
        return (new StringBuilder()).append(firstLetter).append(name.substring(1)).toString();
    }

}
