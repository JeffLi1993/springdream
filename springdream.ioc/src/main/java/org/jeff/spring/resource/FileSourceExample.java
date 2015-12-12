package org.jeff.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
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

/**
 * @author Jeff Lee
 * @since 2015-12-1 20:31:54
 *  Spring的Resource获取文件信息
 */
public class FileSourceExample {
    public static void main(String[] args) {
        try {
            String filePath = "E:\\JEELearning\\ideaworlplace\\springdream\\springdream.ioc\\src\\main\\resources\\FileSource.txt";
            // 使用系统文件路径方式加载文件
            Resource res1 = new FileSystemResource(filePath);
            // 使用类路径方式加载文件
            Resource res2 = new ClassPathResource("FileSource.txt");

            System.out.println("系统文件路径方式:" + res1.getFilename());
            System.out.println("类路径方式:" + res2.getFilename());

            InputStream in1 = res1.getInputStream();
            InputStream in2 = res2.getInputStream();
//            System.out.println("系统文件路径方式:" + read(in1));
//            System.out.println("类路径方式:" + read(in2));
            System.out.println("系统文件路径方式:" + new String(FileCopyUtils.copyToByteArray(in1)));
            System.out.println("类路径方式:" +  new String(FileCopyUtils.copyToByteArray(in2)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取文件内容，返回内容字符串
    public static String read(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            // 创建缓存字符输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String s;
                // 读取一个文本行
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
