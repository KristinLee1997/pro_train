package com.kristin.java.pair;

/**
 * @author hang li
 * @since 2018/4/16
 */
public class PairDemo {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<Integer, String>(1, "a");
        System.out.println(pair.getSecond());
    }
}
