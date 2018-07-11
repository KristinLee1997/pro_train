package com.kristin.guava.basicUtilites;


import com.google.common.base.Objects;
import org.junit.Test;

/**
 * @author hang li
 * @since 2018/5/22
 * 常见Object方法
 */
public class OptionalTest3 {
    @Test
    public void test() {
        //1.equals()
        boolean test1 = Objects.equal("a", "a"); // returns true
        System.out.println(test1);
        boolean test2 = Objects.equal(null, "a"); // returns false
        System.out.println(test2);
        boolean test3 = Objects.equal("a", null); // returns false
        System.out.println(test3);
        boolean test4 = Objects.equal(null, null); // returns true
        System.out.println(test4);

        //2.hashCode()
        System.out.println(Objects.hashCode("abc"));

        //3.toString():  api文档已经没有这个方法啦
//        People person = myObserver People("krisitn", 12);
//        String result = Objects.toStringHelper(People.class).add("name", person.name)
//                .add("age", person.age).toString();


    }
}
