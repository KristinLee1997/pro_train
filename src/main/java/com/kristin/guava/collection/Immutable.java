package com.kristin.guava.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.util.Collection;

/**
 * @author hang li
 * @since 2018/5/22
 * 不可变集合
 */
public class Immutable {
    /*1.创建不可变集合:
     *   ImmutableSet.of()
     *   ImmutableMap.of()
     *   ImmutableSet.copyOf()
     *   ImmutableSortedSet.of()
     */
    private static final ImmutableSet<String> COLORS = ImmutableSet.of("a", "s", "d", "c");

    private static final ImmutableSet<String> COLORS2 = ImmutableSet.copyOf(COLORS);

    private static final ImmutableSortedSet<String> SORTED_SET = ImmutableSortedSet.of("aa", "dd", "ss", "cc");

    private static final ImmutableMap<Integer, String> map = ImmutableMap.of(1, "a", 2, "b", 3, "c");

    private static final ImmutableSet<Color> WEBSAFE_COLORS = ImmutableSet.of(new Color(1, 2, 3), new Color(2, 3, 4), new Color(3, 4, 5));

    public static final ImmutableSet<Color> GOOGLE_COLORS = ImmutableSet.<Color>builder().addAll(WEBSAFE_COLORS).add(new Color(0, 191, 255)).build();

    @Test
    public void testCopyOf() {
        ImmutableSet<String> boobar = ImmutableSet.of("foo", "bar", "baz");
        ImmutableList<String> list = setToList(boobar);
        System.out.println(list);
    }

    public ImmutableList<String> setToList(Collection<String> collection) {
        ImmutableList<String> list = ImmutableList.copyOf(collection);
        return list;
    }

    @Test
    public void test() {
//        System.out.println(GOOGLE_COLORS);
        System.out.println(GOOGLE_COLORS.asList().get(2));  //所有不可变集合都有asLis
        System.out.println(COLORS);
        System.out.println(COLORS2);
        System.out.println(SORTED_SET);
    }
}
