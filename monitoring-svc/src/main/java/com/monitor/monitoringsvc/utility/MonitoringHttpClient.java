package com.monitor.monitoringsvc.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class MonitoringHttpClient {

    @Value("${customconfig.monitoring-config-svc-url}")
    private String configSvcUrl;

    @Value("${customconfig.monitoring-svc-refresh-url}")
    private String refreshUrl;

    @Autowired
    private RestTemplate restTemplate;

    public void componentsBuilder(Map<String, String> configParams) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> entity = new HttpEntity<>(headers);


        final ResponseEntity<Map> mapResponseEntity = restTemplate.postForEntity(configSvcUrl, configParams, Map.class);

        if (mapResponseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("lasjkddfhasdkjfsdfjksdjhgsdf");
            //restTemplate.exchange(refreshUrl, HttpMethod.POST, entity, Void.class);


        }


    }


}
