package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.demo.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangtao 2018-04-23 22:40.
 */
public class Bootstrap {

    public static void main(String[] args) {
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy

        while (true) {
            try {
                Thread.sleep(1000);
                String hello = demoService.sayHello("world"); // call remote method
                System.out.println(hello); // get result
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
