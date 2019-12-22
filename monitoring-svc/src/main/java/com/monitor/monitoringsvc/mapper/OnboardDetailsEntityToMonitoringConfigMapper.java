package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import com.monitor.monitoringsvc.model.MonitoringConfig;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OnboardDetailsEntityToMonitoringConfigMapper {

    public Map<String, String> map(final OnboardDetailsEntity onboardDetailsEntity) {
        final MonitoringConfig monitoringConfig = new MonitoringConfig();
        final Map<String, String> configMap = new HashMap<>();

        configMap.put("serviceName", onboardDetailsEntity.getServiceName());
        configMap.put("serviceId", onboardDetailsEntity.getServiceId());
        configMap.put("applicationProfile", onboardDetailsEntity.getApplicationProfile());
        configMap.put("label", "latest");
        configMap.put("url", onboardDetailsEntity.getServiceUrl());
        configMap.put("path", onboardDetailsEntity.getServiceContextPath() + "**");
        configMap.put("stripPrefix", "false");


        return configMap;
    }
}
