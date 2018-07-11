package com.kristin.java.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/6/21 0:46
 * @desc
 **/
public class RedisDemo {
    public static void set(String key, String value) {
        Jedis jedis = new Jedis("localhost");
        jedis.set(key, value);
        String val = jedis.get(key);
        System.out.println("SET " + key + ":" + val);
        jedis.close();
    }

    public static void sadd(String key, String[] value) {
        Jedis jedis = new Jedis("localhost");
        for (String val : value) {
            jedis.sadd(key, val);
            System.out.println("SADD " + key + ":" + val);
        }
        jedis.close();
    }

    public static void hset(String key, String[] string) {
        Jedis jedis = new Jedis("localhost");
        for (int i = 0; i < string.length - 1; i = i + 2) {
            jedis.hset(key, string[i], string[i + 1]);
            System.out.println("HSET " + key + ":" + string[i] + ":" + string[i + 1]);
        }
        jedis.close();
    }

    public static void keys(String pattern) {
        Jedis jedis = new Jedis("localhost");
        Set<String> s = jedis.keys(pattern);
        int k = 1;
        for (String i : s) {
            System.out.println("(" + k + ") " + i);
            k++;
        }
        jedis.close();
    }

    public static void del(String[] key) {
        Jedis jedis = new Jedis("localhost");
        for (String str : key) {
            jedis.del(str);
            System.out.println("Deleted: " + str);
        }
        jedis.close();
    }

    public static void exist(String[] key) {
        Jedis jedis = new Jedis("localhost");
        for (String str : key) {
            if (jedis.exists(str)) {
                System.out.println(str + " Exists!");
            } else
                System.out.println(str + " Don't Exists!");
        }
        jedis.close();
    }


    public static void rename(String key, String newKey) {
        Jedis jedis = new Jedis("localhost");
        jedis.rename(key, newKey);
        System.out.println(key + " renamed to " + newKey);
        jedis.close();
    }

    public static void get(String key) {
        Jedis jedis = new Jedis("localhost");
        String value = jedis.get(key);
        System.out.println("GET " + key + ":" + value);
        jedis.close();
    }

    public static void time(String instruction, String key, int time) {
        Jedis jedis = new Jedis("localhost");
        switch (instruction) {
            case "expire": {
                jedis.expire(key, time);
                System.out.println("Key " + key + " can live " + time + "s");
                break;
            }
            case "ttl": {
                if (jedis.ttl(key) != -1) {
                    System.out.println("Key " + key + " left " + jedis.ttl(key) + "s now");
                } else
                    System.out.println("Key " + key + " is persisted");
                break;
            }
            case "persist": {
                jedis.persist(key);
                System.out.println("Key " + key + " is persisted");
                break;
            }
        }
        jedis.close();
    }

    public static void type(String key) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("The type of Key " + key + " is: " + jedis.type(key));
        jedis.close();
    }

    public static void randomkey() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Random Key: " + jedis.randomKey());
        jedis.close();
    }

    public static void flushDB() {
        Jedis jedis = new Jedis("localhost");
        if (jedis.flushDB() != null) {
            System.out.println("All keys are cleaned");
        }
        jedis.close();
    }

    public static void main(String[] args) {
        get("name");
    }
}
