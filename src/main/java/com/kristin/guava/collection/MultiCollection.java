package com.kristin.guava.collection;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.HashMultiset.create;

/**
 * @author hang li
 * @since 2018/5/25
 * 新集合类型
 */
public class MultiCollection {
    @Test
    public void testMultiset() {
        // HashMultiset.create()
        // add()
        Multiset<String> multiSet = create();
        multiSet.add("a");
        multiSet.add("b");
        multiSet.add("c");
        multiSet.add("a");
        multiSet.add("b");
        System.out.println(multiSet);

        //addAll()
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("a", "b", "c", "d", "d", "c"));
        Multiset<String> multiSet2 = create();
        multiSet2.addAll(list);
        System.out.println(multiSet2);

        //size()
        System.out.println(multiSet2.size());

        //remove()
        multiSet2.remove("b");
        System.out.println(multiSet2);

        //elementSet()
        for (String key : multiSet2.elementSet()) {
            System.out.println("key: " + key + "  count: " + multiSet2.count(key));
        }

        //contains()
        //setCount()
        if (multiSet2.contains("a")) {
            multiSet2.setCount("a", 23);
        }
        System.out.println(multiSet2);

        //entrySet()
        System.out.println(multiSet2.entrySet());

    }

    @Test
    public void testMultiMap() {
        // put()
        Multimap<Integer, String> map = HashMultimap.create();
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(3, "cc");
        System.out.println("map: " + map);

        //size()
        System.out.println(map.size());

        //putAll()
        Multimap<Integer, String> mapp = HashMultimap.create();
        mapp.putAll(1, map.values());
        mapp.putAll(2, map.values());
        System.out.println("mapp: " + mapp);

        //remove()
        map.remove(2, "bb");
        System.out.println("map: " + map);

        //removeAll()
        mapp.removeAll(2);
        System.out.println("mapp" + mapp);

        //replaceValues()
        Multimap<Integer, String> maap = HashMultimap.create();
        maap.put(11, "aa");
        maap.put(22, "bb");
        maap.put(33, "cc");
        map.replaceValues(1, maap.values());
        System.out.println("map: " + map);
    }

    @Test
    public void testBiMap() {
        //put()
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "a");
        biMap.put(4, "d");
        biMap.put(3, "c");
        biMap.put(2, "b");
        System.out.println(biMap);

        //inverse()
        System.out.println(biMap.inverse());

        //values()
        System.out.println(biMap.values());

        //forcePut()
        biMap.forcePut(2, "bb");
        System.out.println(biMap);
    }


}
