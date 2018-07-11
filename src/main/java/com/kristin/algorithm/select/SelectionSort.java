package com.kristin.algorithm.select;

import com.kristin.algorithm.SortTestHelper;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/7 15:46
 * @desc
 **/
public class SelectionSort {
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr, i, minIndex);
        }
    }
}
