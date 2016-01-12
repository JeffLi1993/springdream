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

import org.jeff.spring.ioc.IocConfig;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author BYSocket
 * @since 2016-01-11 16:39:00
 */
public class ClassScannerHelper {

    private static final ClassScanner classScanner = ClassScannerFactory.getClassScanner();

    /**
     * 获取基础包名中的所有类
     */
    public static List<Class<?>> getClassList() {
        return classScanner.getClassList(IocConfig.pageName);
    }

    /**
     * 获取基础包名中指定注解的相关类
     * @param annotationClass 注解类
     */
    public static List<Class<?>> getClassListByAnnotation(Class<? extends Annotation> annotationClass) {
        return classScanner.getClassListByAnnotation(IocConfig.pageName,annotationClass);
    }
}
