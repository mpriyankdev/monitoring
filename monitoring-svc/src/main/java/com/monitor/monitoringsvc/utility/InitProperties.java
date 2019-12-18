package com.monitor.monitoringsvc.utility;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@ConfigurationProperties
@Component
public class InitProperties {

    //private static Map<String, String> zuulProperties;
    private Properties properties = new Properties();

    @PostConstruct
    public void setZuulConfigurations() {

        System.out.println("***********SETTING ZUUL CONFIGURATIONS**********************");

        properties.setProperty("zuul.routes.stub-svc-1.url", "http://localhost:8081");
        properties.setProperty("zuul.routes.stub-svc-1.path", "/stub1/hello/**");
        properties.setProperty("zuul.routes.stub-svc-1.strip-prefix", "false");
        properties.setProperty("zuul.routes.stub-svc-1.service-id", "stub-svc-1");
        properties.setProperty("zuul.routes.stub-svc-2.url", "http://localhost:8082");
        properties.setProperty("zuul.routes.stub-svc-2.path", "/stub2/hello/**");
        properties.setProperty("zuul.routes.stub-svc-2.strip-prefix", "false");
        properties.setProperty("zuul.routes.stub-svc-2.service-id", "stub-svc-2");


//        zuulProperties = new HashMap<>();
//        zuulProperties.put("zuul.routes.stub-svc-1.url", "http://localhost:8081");
//        zuulProperties.put("zuul.routes.stub-svc-1.path", "/stub1/hello/**");
//        zuulProperties.put("zuul.routes.stub-svc-1.strip-prefix", "false");
//        zuulProperties.put("zuul.routes.stub-svc-1.service-id", "stub-svc-1");
//
//        zuulProperties.put("zuul.routes.stub-svc-2.url", "http://localhost:8082");
//        zuulProperties.put("zuul.routes.stub-svc-2.path", "/stub2/hello/**");
//        zuulProperties.put("zuul.routes.stub-svc-2.strip-prefix", "false");
//        zuulProperties.put("zuul.routes.stub-svc-2.service-id", "stub-svc-2");
    }

}
