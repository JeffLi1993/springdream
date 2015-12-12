package org.jeff.spring.proxy;

/**
 * Created by BYSocket on 2015/11/16.
 */
public class CGLibProxyTest {
    public static void main(String[] args) {
        Hello hello = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        hello.say("BYSocket");
    }
}
