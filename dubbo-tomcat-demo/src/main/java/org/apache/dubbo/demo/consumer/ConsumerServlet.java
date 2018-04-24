package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.demo.provider.DemoService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangtao 2018-04-23 22:31.
 */
@WebServlet(name = "consumer", urlPatterns = {"/dubbo-demo/consumer"})
public class ConsumerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils
                .getWebApplicationContext(getServletContext());
        DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy
        String hello = demoService.sayHello("world"); // call remote method
        PrintWriter out = response.getWriter();
        out.println(hello);
    }
}
