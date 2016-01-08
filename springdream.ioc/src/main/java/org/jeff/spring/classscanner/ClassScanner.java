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

import java.util.List;

/**
 * 类扫描器
 *
 * @author BYSocket
 * @since 2016-01-07 19:36:00
 */
public interface ClassScanner {
    public final static String CLASS_SCANNER = "org.jeff.class_scanner";

    /**
     * 获取指定包名中的所有类
     * @param packageName
     * @return
     */
    List<Class<?>> getClassList(String packageName);
}