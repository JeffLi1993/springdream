package org.jeff.spring.classscanner; /*
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

import org.jeff.spring.classscanner.impl.DefaultClassScanner;
import org.jeff.spring.classscanner.util.ObjectUtil;
import org.jeff.spring.util.StringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类加载器实例工厂
 * @author BYSocket
 * @since 2016-01-08 10:40:00
 */
public class ClassScannerFactory {

    /**
     * 用于缓存实例
     */
    private static final Map<String,Object> classScannerCache = new ConcurrentHashMap<String,Object>();

    public static ClassScanner getClassScanner() {
        return getInstance(ClassScanner.CLASS_SCANNER, DefaultClassScanner.class);
    }

    /**
     * 获取实例
     * @param classKey 缓存键值
     * @param defaultImplClass 默认实现类
     * @param <T>
     * @return
     */
    public static <T> T getInstance(String classKey, Class<T> defaultImplClass) {
        // 如果缓存中存在实例，则返回该实例
        if (classScannerCache.containsKey(classKey)) {
            return (T) classScannerCache.get(classKey);
        }

        // 获取实现类类名
        String implClassName = defaultImplClass.getName();

        // 如果缓存键值为空,使用默认实现类名
        if (StringUtil.isEmpty(classKey)) {
            classKey = implClassName;
        }

        // 通过反射创建实现类的实例
        T instance = ObjectUtil.newInstance(implClassName);

        // 如果实例不为空，放入缓存
        if (instance != null) {
            classScannerCache.put(classKey,instance);
        }

        return instance;
    }
}
