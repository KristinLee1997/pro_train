package com.kristin.algorithm.bubble;

import com.kristin.algorithm.SortTestHelper;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/7 15:25
 * @desc
 **/
public class BubbleSort {
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    SortTestHelper.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public void sort2(Comparable[] arr) {
        for (int i = 0, pos = 0; i < arr.length; i = arr.length - pos) {
            pos = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    SortTestHelper.swap(arr, j, j + 1);
                    pos = j + 1;
                }
            }
        }
    }
}
