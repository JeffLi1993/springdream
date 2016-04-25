package org.spring.bean.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by BYSocket on 2015/12/10.
 */
@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar(){
        Car car = new Car();
        car.setName("Car one");
        return car;
    }
}
