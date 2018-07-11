package com.kristin.nowcoder.second;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberA1 = scan.nextInt();
        int numberA2 = scan.nextInt();
        int numberA3 = scan.nextInt();
        int numberB1 = scan.nextInt();
        int numberB2 = scan.nextInt();
        int numberB3 = scan.nextInt();
        int[] arrA = new int[14];
        int[] arrB = new int[14];
        for (int i = 1; i <= 13; i++) {
            arrA[i] = 4;
            arrB[i] = 4;
        }
        arrA[numberA1]--;
        arrA[numberA2]--;
        arrA[numberA3]--;
        arrB[numberB1]--;
        arrB[numberB2]--;
        arrB[numberB3]--;
        int count1 = numberA1 + numberA2 + numberA3;
        int count2 = numberB1 + numberB2 + numberB3;
        int sub = count1 - count2;
        if (sub >= 13) {
            System.out.println(1.0000);
        } else if (sub <= -13 || Math.abs(sub) == 12) {
            System.out.println(0.0000);
        } else if (sub < 0) {
            double count = 0;
            for (int i = 1 + Math.abs(sub) + 1; i < arrA.length; i++) {
                int sumB = 0;
                for (int j = 1; j < i - Math.abs(sub); j++) {
                    sumB += arrB[j];
                }
                count += arrA[i] * sumB;
            }
            System.out.printf("%.4f", count / (49 * 49));
        } else {
            double count = 0;
            for (int i = 1; i < arrA.length; i++) {
                int sumB = 0;
                for (int j = 1; j < i + Math.abs(sub); j++) {
                    sumB += arrB[j];
                }
                count += sumB * arrA[i];
            }
            System.out.printf("%.4f", count / (49 * 49));
        }
    }
}
