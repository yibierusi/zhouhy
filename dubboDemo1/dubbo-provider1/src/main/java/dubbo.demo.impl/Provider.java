package dubbo.demo.impl;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者： zhouhy
 * 时间：2018/1/9.
 * 说明：
 */

public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        System.out.println(context.getDisplayName() + ": here1");
        context.start();
        System.out.println("服务已经启动1...");
        System.in.read();
    }
}
