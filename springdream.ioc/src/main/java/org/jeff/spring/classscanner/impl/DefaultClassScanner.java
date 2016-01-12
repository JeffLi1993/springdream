package org.jeff.spring.classscanner.impl; /*
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

import org.jeff.spring.classscanner.ClassScanner;
import org.jeff.spring.classscanner.support.AnnotationClassTemplate;
import org.jeff.spring.classscanner.support.ClassTemplate;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * 默认类扫描器
 * @author BYSocket
 * @since 2016-01-07 19:40:00
 */
public class DefaultClassScanner implements ClassScanner {
    public List<Class<?>> getClassList(String packageName) {
        return new ClassTemplate(packageName) {
            @Override
            public boolean checkAddClass(Class<?> cls) {
                String className = cls.getName();
                String pkgName   = className.substring(0, className.lastIndexOf("."));
                return pkgName.startsWith(packageName);
            }
        }.getClassList();
    }

    public List<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass) {
        return new AnnotationClassTemplate(packageName,annotationClass) {

            @Override
            public boolean checkAddClass(Class<?> cls) {
                return cls.isAnonymousClass();
            }
        }.getClassList();
    }
}
