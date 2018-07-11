package com.kristin.java.proxy.jdkproxy2;

/**
 * @author hang li
 * @since 2018/5/8
 */
public class UserDaoImpl implements UserDao {
    @Override
    public String add() {
        System.out.println("------------add------------");
        return "this is add";
    }
}
