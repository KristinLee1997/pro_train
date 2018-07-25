package com.kristin.java.design_pattern.decorator;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/22 13:41
 * @desc
 **/
public abstract class AbstractBorder implements Display {
    Display display;

    public AbstractBorder(Display display) {
        this.display = display;
    }
}
