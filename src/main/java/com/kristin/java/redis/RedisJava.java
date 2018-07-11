package com.kristin.java.redis;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/6/21 0:44
 * @desc
 **/
public class RedisJava {
    public static void main(String[] args) {
//        RedisDemo.get("name");
//        RedisDemo.set("age", "20");
//        String[] strArr = {"aa", "bb", "cc"};
//        RedisDemo.sadd("teamName", strArr);
//        RedisDemo.move("name",1);
        String[] sArr = {"age"};
        RedisDemo.exist(sArr);
    }
}
