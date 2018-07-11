package com.kristin.java;

import org.junit.Test;

/**
 * @author hang li
 * @since 2018/5/22
 */
public class Person {
    private int id;
    private String name;
    private String sex;
    private Person Friend;

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Person getFriend() {
        return Friend;
    }

    public Person setFriend(Person friend) {
        Friend = friend;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", Friend=" + Friend +
                '}';
    }

    @Test
    public void test1() {
        System.out.println(new Person()
                .setId(1504010806)
                .setName("tu").setSex("girl").setFriend(new Person().setId(1504010804).setName("gou").setSex("boy")));
        //Person{id=1504010806, name='tu', sex='girl', Friend=Person{id=1504010804, name='gou', sex='boy', Friend=null}}
    }

    @Test
    public void test() {
        Person gou = new Person();
        gou.setId(1504010804);
        gou.setName("gou");
        gou.setSex("boy");
        Person tu = new Person();
        tu.setId(1504010806);
        tu.setName("tu");
        tu.setSex("girl");
        tu.setFriend(gou);
        System.out.println(tu);
        //Person{id=1504010806, name='tu', sex='girl', Friend=Person{id=1504010804, name='gou', sex='boy', Friend=null}}
    }

}
