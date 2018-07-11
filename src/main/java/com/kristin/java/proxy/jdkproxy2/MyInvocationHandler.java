package com.kristin.java.proxy.jdkproxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hang li
 * @since 2018/5/8
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public void setProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------before-------------");
//        Object result = method.invoke(target, args);
        proxy = method.invoke(target, args);
//        System.out.println("result: "+result);
        System.out.println("proxy: " + proxy);
        System.out.println("-------------after-------------");
        return proxy;
    }

}
