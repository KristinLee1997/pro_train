package com.kristin.java.design_pattern.observer;

/**
 * @author hang li
 * @since 2018/5/9
 */
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerate numberGenerate) {
        System.out.println("DigitObserver: " + numberGenerate.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

