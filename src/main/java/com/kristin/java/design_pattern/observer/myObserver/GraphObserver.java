package com.kristin.java.design_pattern.observer.myObserver;

/**
 * @author hang li
 * @since 2018/5/25
 */
public class GraphObserver implements Observer {
    @Override
    public void update(Generate generate) {
        for (int i = 0; i < generate.getNumber(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
