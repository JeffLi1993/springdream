package org.jeff.spring.proxy;

/**
 * Created by BYSocket on 2015/11/16.
 */
public class HelloImpl implements Hello {

    @Override
    public void say(String name) {
        System.out.println("Hello," + name);
    }
}
