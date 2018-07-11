package com.kristin.java.proxy.jdkproxy2;


import java.lang.reflect.Proxy;

/**
 * @author hang li
 * @since 2018/5/8
 */
public class MyProxy {
    public static void main(String[] args) {
        UserDao user = new UserDaoImpl();
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setProxy(user);
//        UserDao userDao = (UserDao) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), handler);
        UserDao userDao = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class}, handler);
        userDao.add();
    }
}
