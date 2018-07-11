package com.kristin.java.proxy.jdkproxy;

/**
 * @author hang li
 * @since 2018/5/4
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
