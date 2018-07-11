package com.kristin.java.proxy.aop;

import com.kristin.java.proxy.jdkproxy.HelloService;
import com.kristin.java.proxy.jdkproxy.HelloServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author hang li
 * @since 2018/5/4
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAop {
    @Test
    public void test() {
        HelloProxy helloProxy = new HelloProxy();
        HelloService helloService = (HelloService) helloProxy.bind(new HelloServiceImpl());
        ConfigBean config = new ConfigBean();
        config.setFlag(true);
        config.setUseAround(true);
        helloProxy.setConfigBean(config);
        helloService.sayHello("张三");
    }
}
