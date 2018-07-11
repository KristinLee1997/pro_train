package com.kristin.java.string;

/**
 * @author hang li
 * @since 2018/4/18
 */
public class StringDemo {
    public static void main(String[] args) {
        fun(5, 5, 6, 7);
    }

    /**
     * int... 相当于传入一个数组,但是数组内元素类型必须一致
     *
     * @param str
     */
    public static void fun(int... str) {
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
