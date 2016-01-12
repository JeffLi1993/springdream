package org.jeff.ioc; /*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;
import org.jeff.spring.ioc.BeanContainer;
import org.jeff.spring.ioc.IocContainer;
import org.junit.Test;

/**
 * 测试IOC容器
 * @author BYSocket
 * @since 2016-01-12 10:47:00
 */
public class IocT extends TestCase {
    static {
        // 初始化IOC容器
        IocContainer iocContainer = new IocContainer();
    }

    @Test
    public void testIoc() {
        // 从Bean容器获取Class
        Car car = (Car) BeanContainer.getBeanMap().get(Car.class);
        System.out.println(car.getName());
        System.out.println(car.getLunzi().getName());
    }
}
