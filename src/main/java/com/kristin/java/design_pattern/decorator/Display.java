package com.kristin.java.design_pattern.decorator;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/22 13:41
 * @desc
 **/
public interface Display {
    int getColumns();

    int getRows();

    String getRowText(int row);

    default void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
