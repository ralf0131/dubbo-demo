package org.apache.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangtao 2018-04-19 09:36.
 */
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"META-INF/spring/dubbo-demo-provider.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }
}
