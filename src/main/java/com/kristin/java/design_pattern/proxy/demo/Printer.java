package com.kristin.java.design_pattern.proxy.demo;

/**
 * @author hang li
 * @since 2018/5/11
 */
public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成(Printer)" + name + "的实例");
    }

    @Override
    public String getPrintName() {
        return this.name;
    }

    @Override
    public void setPrintName(String name) {
        this.name = name;
    }

    @Override
    public void print(String str) {
        System.out.println("==" + name + "==");
        System.out.println(str);
    }

    public void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("over");
    }
}
