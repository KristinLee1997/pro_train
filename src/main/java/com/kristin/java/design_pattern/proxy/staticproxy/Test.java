package com.kristin.java.design_pattern.proxy.staticproxy;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/10 22:37
 * @desc
 **/
public class Test {

    IMath math = new MathProxy();

    @org.junit.Test
    public void test() {
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}
