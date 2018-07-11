package com.kristin.java.niming;

import java.util.ArrayList;

/**
 * @author hang li
 * @since 2018/4/17
 */
public class Demo {
    public static void main3(String[] args) {
        ArrayList<Person> result = new ArrayList<Person>() {{
            this.add(new Person());
            add(new Person());
        }};

        result.add(new Person());
    }

    public static void main2(String[] args) {
        ArrayList<Person> result = new ArrayList<Person>() {{
            add(new Person() {{
                this.setAge(20);
                this.setName("fasd");
            }});
        }};
    }

    public static void main(String[] args) {
        Person a = new Person() {
            {
                setName(getDefaultName());
            }

            private String getDefaultName() {
                return "lihang";
            }
        };
        System.out.println(a.getName());


        Person b = new Person() {{
            setName("lihang");
        }};
        System.out.println(b.getName());
    }
}


class A {

}