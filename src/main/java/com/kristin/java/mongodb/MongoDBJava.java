package com.kristin.java.mongodb;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/6/25 19:11
 * @desc
 **/
public class MongoDBJava {
    public static void main(String[] args) {
        MongoDBDemo.createCollection("test");
        MongoDBDemo.collectionFindAll("test");
    }
}
