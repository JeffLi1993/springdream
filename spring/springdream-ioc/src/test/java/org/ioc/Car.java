package org.ioc; /*
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

import org.spring.ioc.annotation.Bean;
import org.spring.ioc.annotation.Inject;

/**
 * @author BYSocket
 * @since 2016-01-12 10:45:00
 */
@Bean
public class Car {
    private String name = "car";
    @Inject
    private Lunzi lunzi;

    public String getName() {
        return name;
    }

    public Lunzi getLunzi() {
        return lunzi;
    }
}
