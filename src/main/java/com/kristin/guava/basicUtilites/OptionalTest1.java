package com.kristin.guava.basicUtilites;

import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author hang li
 * @since 2018/5/22
 * 使用和避免null: Optional不包含为null的值(包含非null的引用和缺失引用)
 */
public class OptionalTest1 {
    public static void main(String[] args) {
        OptionalTest1 op = new OptionalTest1();
//        op.create();
//        op.query();

        String first = "this is first";
        String second = "always not null";
        String isNull = null;
        System.out.println(Optional.fromNullable(isNull).or(second));
    }

    /**
     * 创建Optional实例
     */
    public void create() {
        //1.创建自定引用的Optional实例,若为null,则快速失败
        Optional test1 = Optional.of("3");
        System.out.println(test1.get());
//        String t2 = null;
//        Optional test2 = Optional.of(t2);
//        System.out.println(test2.get());

        //2.创建引用缺失的实例
        Optional test3 = Optional.absent();
        System.out.println(test3.orNull());

        //3.创建指定引用的Optional实例，若引用为null则表示缺失
        String t4 = "abc";
        String t5 = null;
        Optional test4 = Optional.fromNullable(t4);
        System.out.println(test4.orNull());
        Optional test5 = Optional.fromNullable(t5);
        System.out.println(test5.orNull());
    }

    /**
     * 查询Optional引用
     */
    public void query() {
        Optional hasNull = Optional.absent();
        Optional notNull = Optional.of("abc");

        //1.如果Optional包含非null的引用（引用存在），返回true
        System.out.println(hasNull.isPresent());
        System.out.println(notNull.isPresent());

        //2.返回Optional所包含的引用，若引用缺失，则抛出java.lang.IllegalStateException
//        System.out.println(hasNull.get());
        System.out.println(notNull.get());

        //3.返回Optional所包含的引用，若引用缺失，返回指定的值
        System.out.println(hasNull.or("has null"));
        System.out.println(notNull.or("has null"));

        //4.返回Optional所包含的引用，若引用缺失，返回nul
        System.out.println(hasNull.orNull());
        System.out.println(notNull.orNull());

        //5.返回Optional所包含引用的单例不可变集，如果引用存在，返回一个只有单一元素的集合，如果引用缺失，返回一个空集合。
        List list = new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        Optional op = Optional.of(list);
        Set<String> set = op.asSet();
        System.out.println(set);
    }
}
