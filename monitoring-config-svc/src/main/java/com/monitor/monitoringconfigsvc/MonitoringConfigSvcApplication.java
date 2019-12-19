package com.monitor.monitoringconfigsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MonitoringConfigSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringConfigSvcApplication.class, args);
    }

}
