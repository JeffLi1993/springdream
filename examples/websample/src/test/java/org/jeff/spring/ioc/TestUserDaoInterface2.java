package org.jeff.spring.ioc;

import org.jeff.spring.test.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestUserDaoInterface2 extends UnitTestBase{
	public TestUserDaoInterface2() {
		super("classpath*:spring-ioc.xml");
	}
	
	@Test
	public void testSave(){
		UserDaoInterface udi = super.getBean("userDaoInterface");
		udi.save("Jeff");
	}
}