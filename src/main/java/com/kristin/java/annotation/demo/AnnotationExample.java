package com.kristin.java.annotation.demo;

/**
 * @author hang li
 * @since 2018/4/17
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {

    public static void main(String[] args) {
    }

    @Deprecated //当我们想要让编译器知道一个方法已经被弃用(deprecate)时，应该使用这个注解。Java推荐在javadoc中提供信息，告知用户为什么这个方法被弃用了，以及替代方法是什么。
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    //这个注解仅仅是告知编译器，忽略它们产生了特殊警告，比如：在java泛型中使用原始类型。它的保持性策略(retention policy)是SOURCE，在编译器中将被丢弃。
    @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

    @Override //当我们想要覆盖父类的一个方法时，需要使用该注解告知编译器我们正在覆盖一个方法。这样的话，当父类的方法被删除或修改了，编译器会提示错误信息。大家可以学习一下为什么我们总是应该在覆盖方法时使用Java覆盖注解。
    @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

}
