package com.kristin.java.stream;

import com.kristin.java.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hang li
 * @since 2018/4/27
 */
public class Demo2 {
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People("kristin", 12));
        list.add(new People("king", 13));
        list.add(new People("abc", 12));
        list.add(new People("ddd", 11));
        Map<Integer, List<People>> map = list.stream().collect(Collectors.groupingBy(s -> s.getAge()));
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + "---" + m.getValue());
        }

    }
}
