package com.kristin.java.design_pattern.proxy.demo;

/**
 * @author hang li
 * @since 2018/5/11
 */
public class PrintProxy implements Printable {
    private String name;
    private Printer real;

    public PrintProxy(String name) {
        this.name = name;
    }

    @Override
    public String getPrintName() {
        return this.name;
    }

    @Override
    public synchronized void setPrintName(String name) {
        if (real != null) {
            real.setPrintName(name);
        }
        this.name = name;
    }

    @Override
    public void print(String str) {
        realize();
        real.print(str);
    }

    public synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
