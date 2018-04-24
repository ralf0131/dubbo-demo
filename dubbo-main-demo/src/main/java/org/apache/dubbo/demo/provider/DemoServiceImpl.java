package org.apache.dubbo.demo.provider;

/**
 * @author wangtao 2018-04-19 09:39.
 */
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
