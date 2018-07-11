package com.kristin.java.jdk;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/6/10 10:56
 * @desc 查看ArrayList的Capacity
 **/
public class ArrayCapcity {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        System.out.println(getArrayListCapacity(list));
        list.add("00");
        System.out.println(getArrayListCapacity(list));

    }

    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] objects = (Object[]) field.get(arrayList);
            return objects.length;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
