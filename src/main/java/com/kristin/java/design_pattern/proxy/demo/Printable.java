package com.kristin.java.design_pattern.proxy.demo;

/**
 * @author hang li
 * @since 2018/5/11
 */
public interface Printable {
    String getPrintName();

    void setPrintName(String name);

    void print(String str);
}
