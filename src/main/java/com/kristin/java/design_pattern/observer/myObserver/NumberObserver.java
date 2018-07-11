package com.kristin.java.design_pattern.observer.myObserver;

/**
 * @author hang li
 * @since 2018/5/25
 */
public class NumberObserver implements Observer {
    @Override
    public void update(Generate generate) {
        System.out.println("Number: " + generate.getNumber());
    }
}
