package com.kristin.java.proxy.jdkproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author hang li
 * @since 2018/5/4
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestProxy {

    @Test
    public void test() {
        HelloProxy helloProxy = new HelloProxy();
        HelloService proxy = (HelloService) helloProxy.bind(new HelloServiceImpl());
        proxy.sayHello("kristin");
    }
}
