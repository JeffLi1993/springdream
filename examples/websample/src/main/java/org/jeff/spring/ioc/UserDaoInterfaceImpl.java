package org.jeff.spring.ioc;


public class UserDaoInterfaceImpl implements UserDaoInterface{

	public void save(String userName) {
		System.out.println("保存用户[" + userName + "]");
	}

}
