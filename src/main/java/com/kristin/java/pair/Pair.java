package com.kristin.java.pair;

/**
 * @author hang li
 * @since 2018/4/16
 */
public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T newValue) {
        this.first = newValue;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U newValue) {
        this.second = newValue;
    }
}
