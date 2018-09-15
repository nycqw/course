package com.eden.utils;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Set;

@Service
@Slf4j
public class FieldAutowiredAware implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public FieldAutowiredAware() {
        // 加载继承该类的类
        Reflections reflections = new Reflections(this.getClass(), new FieldAnnotationsScanner());

        // 获取它的实现类中的被自动装配注解标记的字段
        Set<Field> fields = reflections.getFieldsAnnotatedWith(Resource.class);
        for (Field field : fields) {
            String simpleName = field.getType().getSimpleName();
            String beanName = toLowerCaseFirstLetter(simpleName);
            log.info("===============================================================");
            log.info(beanName);

            // 从IOC容器中获取到这些字段的bean对象并进行赋值
            Object bean = applicationContext.getBean(beanName);
            field.setAccessible(true);
            try {
                field.set(this, bean);
            } catch (IllegalAccessException e) {
                log.error("字段设置失败", e);
            }
        }

    }

    private String toLowerCaseFirstLetter(String name) {
        char firstLetter = Character.toLowerCase(name.charAt(0));
        return (new StringBuilder()).append(firstLetter).append(name.substring(1)).toString();
    }
}
