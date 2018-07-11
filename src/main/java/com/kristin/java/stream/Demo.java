package com.kristin.java.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author hang li
 * @since 2018/4/18
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.stream().map((n) -> n.equals("a")).collect(Collectors.toList());
        list.parallelStream().forEach(System.out::println);

        ArrayList<byte[]> result = new ArrayList<byte[]>() {{
            add("123".getBytes());
            add("234".getBytes());
        }};

        Collections.sort(result, new Comparator<byte[]>() {
            @Override
            public int compare(byte[] o1, byte[] o2) {
                return new String(o1).compareTo(new String(o2));
            }
        });

        Collections.sort(result, (a1, a2) -> new String(a1).compareTo(new String(a2)));

        Collections.sort(result, Comparator.comparing(String::new));
    }
}
