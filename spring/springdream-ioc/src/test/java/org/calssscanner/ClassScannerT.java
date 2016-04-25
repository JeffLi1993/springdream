package org.calssscanner; /*
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

import org.spring.classscanner.ClassScanner;
import org.spring.classscanner.ClassScannerFactory;

import java.util.List;

/**
 * @author BYSocket
 * @since 2016-01-07 20:03:00
 */
public class ClassScannerT {
    private static final String packageName = "org.jeff";
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ClassScanner cs = ClassScannerFactory.getClassScanner();
        List<Class<?>> classes = cs.getClassList(packageName);
        for (Class<?> c : classes)
            System.out.println(c.getName());
        long end = System.currentTimeMillis();
        System.out.println("第一次获取耗时：" + (end - start));

        long start1 = System.currentTimeMillis();
        ClassScanner cs1 = ClassScannerFactory.getClassScanner();
        List<Class<?>> classes1 = cs1.getClassList(packageName);
        for (Class<?> c1 : classes1)
            System.out.println(c1.getName());
        long end1 = System.currentTimeMillis();
        System.out.println("第二次从缓冲获取耗时：" + (end1 - start1));

    }
}
