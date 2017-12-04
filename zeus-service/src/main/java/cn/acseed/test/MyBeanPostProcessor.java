package cn.acseed.test;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by caohongchen on 17-1-8.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (StringUtils.equals("car", s)) {
            Car car = (Car)o;
            if (StringUtils.isEmpty(car.getColor())) {
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization(),  color为空， 设置为默认黑色");
                car.setColor("黑色");
            }
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (StringUtils.equals("car", s)) {
            Car car = (Car)o;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("调用BeanPostProcessor.postProcessAfterInitialization(),  将maxSpeed设置为200");
                car.setMaxSpeed(200);
            }
        }
        return o;
    }
}
