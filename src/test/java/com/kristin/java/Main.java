package com.kristin.java;

import java.util.Arrays;

/**
 * @author hang li
 * @since 2018/5/7
 */
public class Main {
    public static void main(String[] args) {
        byte[] a = "0$*+OPING\r\n".getBytes();
        System.out.println(Arrays.toString(a));
    }
}
