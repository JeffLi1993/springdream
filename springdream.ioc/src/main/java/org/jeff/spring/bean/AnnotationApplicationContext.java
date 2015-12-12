package org.jeff.spring.bean;

import org.jeff.spring.bean.pojo.Beans;
import org.jeff.spring.bean.pojo.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by BYSocket on 2015/12/10.
 */
public class AnnotationApplicationContext {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = (Car) ctx.getBean("car");
        System.out.println(car.getName());
    }
}
