package com.kristin.java.javaOptimization;


/**
 * @author hang li
 * @since 2018/5/22
 */
public class Person {
    private int id;
    private String name;
    private String sex;
    private String friend;

    private Person() {
    }

    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sex = builder.sex;
        this.friend = builder.friend;
    }

    public static void main(String[] args) {
        Person newP = new Person.Builder().withId(999).withName("hahaha").withSex("girl").withFriend("gou").build();
        System.out.println(newP);

        Person p = new Person.Builder().build();
        System.out.println(p);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getFriend() {
        return friend;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", friend=" + friend +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private String sex;
        private String friend;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder withFriend(String friend) {
            this.friend = friend;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}