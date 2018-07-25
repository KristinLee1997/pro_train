package com.kristin.java.design_pattern.decorator;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/22 13:55
 * @desc
 **/
public class Main {
    public static void main(String[] args) {
        Display b4 = new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("1234567")
                                        ), '*'
                                )
                        )
                ), '/'
        );
        b4.show();
    }
}
