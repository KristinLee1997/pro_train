package com.kristin.algorithm.insertion;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/7 16:01
 * @desc
 **/
public class InsertionSort {
    public void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];

            }
            arr[j] = temp;
        }
    }
}
