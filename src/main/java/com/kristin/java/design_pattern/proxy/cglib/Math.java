package com.kristin.java.design_pattern.proxy.cglib;

import com.kristin.java.design_pattern.proxy.jdk.IMath;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/10 22:58
 * @desc
 **/
public class Math implements IMath {
    //加
    public int add(int n1, int n2) {
        int result = n1 + n2;
        System.out.println(n1 + "+" + n2 + "=" + result);
        return result;
    }

    //减
    public int sub(int n1, int n2) {
        int result = n1 - n2;
        System.out.println(n1 + "-" + n2 + "=" + result);
        return result;
    }

    //乘
    public int mut(int n1, int n2) {
        int result = n1 * n2;
        System.out.println(n1 + "X" + n2 + "=" + result);
        return result;
    }

    //除
    public int div(int n1, int n2) {
        int result = n1 / n2;
        System.out.println(n1 + "/" + n2 + "=" + result);
        return result;
    }
}
