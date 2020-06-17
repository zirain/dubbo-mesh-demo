package tencent.demo.provider;

import tencent.demo.DemoService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        String myHost = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            myHost = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = format.format(date);
        return "你好世界， 现在是版本 3-http 升级了这个提示 " + name + ", V2 @ " + str + " @ " + myHost ;
    }

    @Override
    public String sayReject(String name) {
        return "我拒绝你, 现在这个是版本 3: " + name ;
    }
}
