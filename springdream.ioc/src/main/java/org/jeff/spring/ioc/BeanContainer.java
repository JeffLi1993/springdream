package org.jeff.spring.ioc; /*
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

import org.jeff.spring.classscanner.ClassScannerFactory;
import org.jeff.spring.classscanner.ClassScannerHelper;
import org.jeff.spring.classscanner.util.ClassUtil;
import org.jeff.spring.ioc.annotation.Bean;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean容器
 *  负责存Bean对象
 * @author BYSocket
 * @since 2016-01-11 16:17:00
 */
public class BeanContainer {

    /**
     * Bean Map (Bean 类 => Bean 实例)
     */
    private static final Map<Class<?>,Object> beanMap = new ConcurrentHashMap<Class<?>,Object>();
    static {
        try {
            // 获取应用包所有路径下的类
            List<Class<?>> classList = ClassScannerHelper.getClassList();
            for (Class<?> cls : classList) {
                // 如果是Bean注解的类
                if (cls.isAnnotationPresent(Bean.class)) {
                    // 创建Bean的实例
                    Object instance  = cls.newInstance();
                    // 将 Bean实例 放入 Bean Map 中（键为 Bean 类，值为 Bean 实例）
                    beanMap.put(cls,instance);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("初始化Bean容器失败！",e);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }
}
