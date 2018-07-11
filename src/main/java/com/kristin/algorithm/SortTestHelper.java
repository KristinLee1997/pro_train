package com.kristin.algorithm;


/**
 * @author hang li
 * @since 2018/5/21
 */
public class SortTestHelper {
    public static Integer[] generateArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    public static void printArray(Comparable[] arr) {
        for (Comparable anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println();
    }

    public static boolean isSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

