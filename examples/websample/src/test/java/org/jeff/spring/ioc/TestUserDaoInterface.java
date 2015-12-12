package org.jeff.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDaoInterface {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 获取Spring Bean容器
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
		// 获取容器中的一个Bean
		UserDaoInterface userDaoInterface = 
				(UserDaoInterface) ctx.getBean("userDaoInterface");
		userDaoInterface.save("Jeff");
	}
}
