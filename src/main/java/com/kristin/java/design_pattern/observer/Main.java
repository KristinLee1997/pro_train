package com.kristin.java.design_pattern.observer;

/**
 * @author hang li
 * @since 2018/5/9
 */
public class Main {
    public static void main(String[] args) {
        NumberGenerate generate = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generate.addObserver(observer1);
        generate.addObserver(observer2);
        generate.execute();
    }
}
