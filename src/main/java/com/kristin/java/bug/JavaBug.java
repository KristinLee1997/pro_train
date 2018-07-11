package com.kristin.java.bug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hang li
 * @since 2018/5/21
 * Java Bug--官方编号为 6260652
 * https://bugs.openjdk.java.net/browse/JDK-6260652
 */
public class JavaBug {
    public static void test1() {
        System.out.println("this is test1...");
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        Object[] arr = list.toArray();
        System.out.println(arr.getClass().getCanonicalName());
        arr[0] = new Object();
        JavaBug.printArr(arr);
    }

    public static void test2() {
        System.out.println("this is test2...");
        List<String> list = Arrays.asList("aa", "bb");
        Object[] arr = list.toArray();
//        Object[] arr = list.toArray(myObserver Object[0]); 正确代码,将数组转换为Object类型
        System.out.println(arr.getClass().getCanonicalName());
        arr[0] = new Object();
        JavaBug.printArr(arr);
    }

    public static void test3() {
        System.out.println("this is test3...");
        Object[] arr = new String[]{"aa", "bb"};
        arr[0] = 1;
        JavaBug.printArr(arr);
    }

    public static void printArr(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* 分别依次调用以下三个函数*/
        /*
         * test1 Output:
         * this is test1...
         * java.lang.Object[]
         * java.lang.Object@2503dbd3  bb
         */
//        JavaBug.test1();
        /*
         * test2 Output:
         * this is test2...
         * java.lang.String[]
         * Exception in thread "main" java.lang.ArrayStoreException: java.lang.Object
         */
        JavaBug.test2();
        /*
         * test3 Output:
         * this is test3...
         * Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
         */
//        JavaBug.test3();
    }
}
