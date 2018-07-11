package com.kristin.java.design_pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hang li
 * @since 2018/5/9
 * 抽象类: 被观察的对象
 */
public abstract class NumberGenerate {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) { //注册observer
        observers.add(observer);
    }

    public void deleteobserver(Observer observer) { //删除observer
        observers.remove(observer);
    }

    public void notifyObservers() { //向observer发送通知
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            o.update(this);
        }

    }

    public abstract int getNumber();//获取数值

    public abstract void execute();//生成数值
}
