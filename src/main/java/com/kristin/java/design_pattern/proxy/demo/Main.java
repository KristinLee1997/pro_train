package com.kristin.java.design_pattern.proxy.demo;

/**
 * @author hang li
 * @since 2018/5/11
 */
public class Main {
    public static void main(String[] args) {
        Printable p = new PrintProxy("kristin");
        System.out.println("name: " + p.getPrintName());
        p.setPrintName("kkk");
        System.out.println("myObserver name: " + p.getPrintName());
        p.print("hello world");
    }
}
