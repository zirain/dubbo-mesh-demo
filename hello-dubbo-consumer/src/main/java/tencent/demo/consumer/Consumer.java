package tencent.demo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import tencent.demo.DemoService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/consumer.xml"});
        context.start();

        DemoService demoService = (DemoService)context.getBean("demoService");


        while(true) {
            var calendar = Calendar.getInstance();
            var formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            var now = formatter.format(calendar.getTime());
            try {
                var hello = demoService.sayHello(now + "|");
                System.out.println(hello);
            } catch (Exception ex) {
                System.out.println(now + "|Provider not ready!|" + ex.getMessage());
            }
            Thread.sleep(5 * 1000);
        }
    }
}
