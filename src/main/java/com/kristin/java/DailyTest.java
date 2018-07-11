package com.kristin.java;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hang li
 * @since 2018/4/20
 */
@Getter
@Setter
@ToString
public class DailyTest {
    private String name;
    private int age;

    public static void main(String[] args) {
        DailyTest dailyTest = new DailyTest();
        dailyTest.setName("kkk");
        dailyTest.setAge(13);
        System.out.println(dailyTest.toString());
    }
}
