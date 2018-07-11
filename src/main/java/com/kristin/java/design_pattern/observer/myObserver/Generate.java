package com.kristin.java.design_pattern.observer.myObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hang li
 * @since 2018/5/25
 */
public class Generate {
    private static final List<Observer> observers = new ArrayList<>();
    private int number;

    public Generate(Integer number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Generate generate = new Generate(30);
        generate.addObserver(new NumberObserver());
        generate.addObserver(new GraphObserver());
        generate.notifyObserver();
        generate.setNumber(50);
        generate.notifyObserver();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
