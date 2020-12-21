package tencent.demo.provider;

import tencent.demo.DemoService;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        var myHost = "";
        var myAddress = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            myAddress = inetAddress.getHostAddress();
            myHost = inetAddress.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        var namespace = System.getenv("POD_NAMESPACE");

        if (namespace == null) {
            namespace = "unkown";
        }


        return name + ",form [ns]=" + namespace + "@" + myHost + ":" + myAddress;
    }
}
