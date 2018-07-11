package com.kristin.java.design_pattern.proxy.staticproxy;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/10 22:35
 * @desc 接口 抽象主题
 **/

public interface IMath {
    //加
    int add(int n1, int n2);

    //减
    int sub(int n1, int n2);

    //乘
    int mut(int n1, int n2);

    //除
    int div(int n1, int n2);

}