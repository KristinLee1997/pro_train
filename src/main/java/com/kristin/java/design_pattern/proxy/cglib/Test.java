package com.kristin.java.design_pattern.proxy.cglib;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/10 23:04
 * @desc
 **/
public class Test {
    //实例化一个DynamicProxy代理对象
    //通过getProxyObject方法获得被代理后的对象
    Math math = (Math) new DynamicProxy().getProxyObject(new Math());

    @org.junit.Test
    public void test01() {
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}