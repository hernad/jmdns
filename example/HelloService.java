import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class HelloService {

        public static void main(String[] args) throws InterruptedException {

            try {
                // Create a JmDNS instance
                //JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
                JmDNS jmdns = JmDNS.create("127.0.0.1");

                // Register a service
                ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "service1", 999, "path=index.html;test=004303404034030430");
                jmdns.registerService(serviceInfo);

                // Wait a bit
                Thread.sleep( Long.MAX_VALUE );

                // Unregister all services
                jmdns.unregisterAllServices();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
}
