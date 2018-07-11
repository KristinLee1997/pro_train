package com.kristin.guava.collection;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hang li
 * @since 2018/5/25
 * Guava集合工具类
 */
public class GuavaCollections {
    /**
     * 使用工厂方法初始化
     */
    @Test
    public void testCreate() {
        //使用工厂方法创建集合
        List<String> list = Lists.newArrayList();
        Map<Integer, String> map = Maps.newHashMap();

        //初始化时指定元素
        Set<String> set = Sets.newHashSet("a", "c", "d", "b");
        List<Integer> list2 = Lists.newArrayList(1, 3, 5, 7, 9);

        //初始化时指定集合大小
//        List<Integer> list3 = Lists.newArrayListWithCapacity(5);
        List<Integer> list3 = Lists.newArrayListWithExpectedSize(5);
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        System.out.println(list3);
        //
        list3.add(6);
        System.out.println(list3);
    }

    @Test
    public void testIterables() {
        Iterable<Integer> concatenated = Iterables.concat(
                Ints.asList(1, 2, 3, 5),
                Ints.asList(4, 5, 6)); // concatenated包括元素 1, 2, 3, 5, 4, 5, 6
        System.out.println(concatenated);
    }
}
