package com.kristin.java.javaOptimization;

import org.junit.Test;

/**
 * @author hang li
 * @since 2018/5/22
 */
public class People {
    private int id;
    private String name;
    private String sex;
    private People friend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public People getFriend() {
        return friend;
    }

    public void setFriend(People friend) {
        this.friend = friend;
    }

    public People withId(int id) {
        this.id = id;
        return this;
    }

    public People withName(String name) {
        this.name = name;
        return this;
    }

    public People withSex(String sex) {
        this.sex = sex;
        return this;
    }

    public People withFriend(People friend) {
        this.friend = friend;
        return this;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", friend=" + friend +
                '}';
    }

    @Test
    public void test1() {
        System.out.println(new People()
                .withId(1504010806)
                .withName("tu")
                .withSex("girl")
                .withFriend(new People().withId(1504010804).withName("gou").withSex("boy")));
        //Person{id=1504010806, name='tu', sex='girl', friend=Person{id=1504010804, name='gou', sex='boy', friend=null}}
    }

    @Test
    public void test() {
        People gou = new People();
        gou.setId(1504010804);
        gou.setName("gou");
        gou.setSex("boy");
        People tu = new People();
        tu.setId(1504010806);
        tu.setName("tu");
        tu.setSex("girl");
        tu.setFriend(gou);
        System.out.println(tu);
        //Person{id=1504010806, name='tu', sex='girl', friend=Person{id=1504010804, name='gou', sex='boy', friend=null}}
    }
}
