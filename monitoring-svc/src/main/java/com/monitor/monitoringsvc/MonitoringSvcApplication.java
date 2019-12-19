package com.monitor.monitoringsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MonitoringSvcApplication {

    public static void main(String[] args) {


        SpringApplication.run(MonitoringSvcApplication.class, args);
    }

}
