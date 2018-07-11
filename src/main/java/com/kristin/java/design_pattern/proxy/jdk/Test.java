package com.kristin.java.design_pattern.proxy.jdk;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/10 22:45
 * @desc
 **/
public class Test {

    //实例化一个MathProxy代理对象
    //通过getProxyObject方法获得被代理后的对象
    IMath math = (IMath) new DynamicProxy().getProxyObject(new Math());

    @org.junit.Test
    public void test() {
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}