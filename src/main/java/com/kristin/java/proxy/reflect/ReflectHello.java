package com.kristin.java.proxy.reflect;

import java.lang.reflect.Method;

/**
 * @author hang li
 * @since 2018/5/4
 * Java方法反射
 */
public class ReflectHello {
    public ReflectHello() {

    }

    public static void main(String[] args) {
        try {
            //通过反射生成对象，相当于 ReflectHello refect = myObserver ReflectHello();
            ReflectHello refect = (ReflectHello) Class.forName("com.kristin.java.proxy.reflect.ReflectHello").newInstance();
            //通过类获取方法，sayHello。
            Method method = refect.getClass().getMethod("sayHello", String.class);
            //相当于语句， refect.sayHello("张三")
            method.invoke(refect, "张三");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}