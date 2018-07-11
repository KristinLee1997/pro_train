package com.kristin.java.design_pattern.observer;

import java.util.Random;

/**
 * @author hang li
 * @since 2018/5/9
 */
public class RandomNumberGenerator extends NumberGenerate {
    private Random random = new Random();
    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
