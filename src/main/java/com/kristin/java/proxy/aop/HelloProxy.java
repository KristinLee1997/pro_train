package com.kristin.java.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hang li
 * @since 2018/5/4
 */
public class HelloProxy implements InvocationHandler {

    private ConfigBean configBean = null;

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ConfigBean config = this.getConfigBean();
        if (!config.isFlag()) {
            return method.invoke(target, args);
        }
        config.before();
        Object obj = null;
        try {
            if (config.isUserAround()) {
                obj = method.invoke(target, args);
            }
        } catch (Exception e) {
            config.afterThrowing();
        }
        config.after();
        return obj;
    }

    public ConfigBean getConfigBean() {
        return configBean;
    }

    public void setConfigBean(ConfigBean configBean) {
        this.configBean = configBean;
    }
}
