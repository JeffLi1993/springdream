package org.jeff.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by BYSocket on 2015/12/7.
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource resource = resolver.getResource("classpath:bean/bean.xml");
//        BeanFactory bf = new XmlBeanFactory(resource);

        BeanFactory bf = new ClassPathXmlApplicationContext("classpath:bean/bean.xml");
        BeanFactoryTest beanFactoryTest = bf.getBean("beanFactoryTest",BeanFactoryTest.class);
        System.out.println(beanFactoryTest.getClass());
    }
}
