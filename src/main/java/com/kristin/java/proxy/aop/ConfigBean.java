package com.kristin.java.proxy.aop;

/**
 * @author hang li
 * @since 2018/5/4
 */
public class ConfigBean {
    private boolean flag = false;   //标记代理对象是否使用这个类进行处理
    private boolean useAround = false;  //是否启用环绕通知

    public void before() {
        System.err.println("前置消息");
    }

    public void after() {
        System.err.println("后置消息");
    }

    public void afterReturn() {
        System.err.println("正常返回后的消息");
    }

    public void afterThrowing() {
        System.err.println("返回后的消息");
    }

    public Object around() {
        System.err.println("环绕通知");
        return null;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isUserAround() {
        return useAround;
    }

    public void setUseAround(boolean useAround) {
        this.useAround = useAround;
    }
}
