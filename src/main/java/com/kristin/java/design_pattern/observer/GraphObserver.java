package com.kristin.java.design_pattern.observer;

/**
 * @author hang li
 * @since 2018/5/9
 */
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerate numberGenerate) {
        System.out.println("GraphObserver: ");
        int count = numberGenerate.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
