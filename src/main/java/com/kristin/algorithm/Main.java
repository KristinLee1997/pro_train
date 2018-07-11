package com.kristin.algorithm;

import com.kristin.algorithm.insertion.InsertionSort;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/7 15:28
 * @desc
 **/
public class Main {
    public static void main(String[] args) {
        Comparable[] arr = {5, 1, 3, 9, 7, 6, 8, 4, 2, 10};
//        BubbleSort ss = new BubbleSort();
//        SelectionSort ss = new SelectionSort();
        InsertionSort ss = new InsertionSort();
        ss.sort(arr);
        SortTestHelper.printArray(arr);
    }
}
