package com.kristin.java.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hang li
 * @since 2018/5/4
 * 动态代理类需要实现InvocationHandler
 */
public class HelloProxy implements InvocationHandler {
    private Object target;

    /**
     * 生成代理对象,并和真实服务对象绑定
     *
     * @param target
     * @return 代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        //生成代理对象并绑定
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxy;
    }

    /**
     * 当生成代理对象时，第三个指定使用HelloProxy进行代理时，代理对象调用的方法就会进入这个方法。
     *
     * @param proxy  --代理对象
     * @param method --被调用的方法
     * @param args   --方法参数
     * @return 代理方法返回
     * @throws Throwable --异常处理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("反射真实对象前");
        Object obj = method.invoke(target, args);   //相当于调用sayHello()
        System.err.println("反射真实对象后");
        return obj;
    }
}
