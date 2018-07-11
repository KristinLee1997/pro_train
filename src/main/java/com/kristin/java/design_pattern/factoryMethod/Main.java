package com.kristin.java.design_pattern.factoryMethod;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/2 9:21
 * @desc
 **/
public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("kristin");
        Product card2 = factory.create("John");
        Product card3 = factory.create("Marry");
        card1.use();
        card2.use();
        card3.use();
    }
}
