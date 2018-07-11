package com.kristin.java.inner;

/**
 * @author hang li
 * @since 2018/5/12
 */
public class Outer {
    private String name;

    public Outer(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Outer out = new Outer("kkk");
        out.new Inner().innerSetOutName();
        System.out.println(out.getName());
        out.new Inner().innerFun();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void outerFun() {
        System.out.println("this is outer function");
    }

    class Inner {
        private String innerName;

        public Inner() {

        }

        public Inner(String innerName) {
            this.innerName = innerName;
        }

        public String getInnerName() {
            return innerName;
        }

        public Inner setInnerName(String innerName) {
            this.innerName = innerName;
            return this;
        }

        public String getOuterName() {
            return name;
        }

        private void innerFun() {
            System.out.println("this is inner function");
        }

        public void innerSetOutName() {
            System.out.println("内部类调用外部类的方法");
            setName("lallala");
        }
    }
}
