package com.kristin.guava.basicUtilites;


import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.Test;

/**
 * @author hang li
 * @since 2018/5/22
 * 排序器(Ordering)----?????不太懂
 */
public class OptionalTest4 {
    @Test
    public void test() {
        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        String a = "aaaaaaaaa";
        String b = "bbbb";
        System.out.println(byLengthOrdering.compare(a, b));

        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, String>() {
            public String apply(Foo foo) {
                return foo.sortedBy;
            }
        });
        Function<Foo, String> aaa = new Function<Foo, String>() {
            @Override
            public String apply(Foo input) {
                return "aaaa";
            }
        };

        Foo foo = new Foo();
        Foo fff = null;
        Ordering<Foo> ordering2 = Ordering.natural().nullsFirst().onResultOf(aaa);
        System.out.println(ordering2.min(foo, fff));
    }
}
