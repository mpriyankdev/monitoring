package com.monitor.monitoringconfigsvc.utility;

import com.monitor.monitoringconfigsvc.constants.AppConstants;
import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.service.MonitoringConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MonitoringConfigUtility {

    @Autowired
    private MonitoringConfigService monitoringConfigService;

    public void configCreator(Map<String, String> mappedParams) {

        final MonitoringConfigEntity monitoringConfigEntity = new MonitoringConfigEntity();


        monitoringConfigEntity.setApplication("monitoring-svc");
        monitoringConfigEntity.setProfile(mappedParams.get("applicationProfile"));
        monitoringConfigEntity.setLabel(mappedParams.get("label"));
        monitoringConfigEntity.setConfigId(mappedParams.get("onboardId") + "_" + AppConstants.URL);
        monitoringConfigEntity.setKey(AppConstants.ZUUL_ROUTES_PREFIX + AppConstants.DOT + mappedParams.get("serviceId") + AppConstants.DOT + AppConstants.URL);
        monitoringConfigEntity.setValue(mappedParams.get("url"));

        monitoringConfigService.saveMonitoringConfiguration(monitoringConfigEntity);

        monitoringConfigEntity.setConfigId(mappedParams.get("onboardId") + "_" + AppConstants.PATH);
        monitoringConfigEntity.setKey(AppConstants.ZUUL_ROUTES_PREFIX + AppConstants.DOT + mappedParams.get("serviceId") + AppConstants.DOT + AppConstants.PATH);
        monitoringConfigEntity.setValue(mappedParams.get("path"));

        monitoringConfigService.saveMonitoringConfiguration(monitoringConfigEntity);

        monitoringConfigEntity.setConfigId(mappedParams.get("onboardId") + "_" + AppConstants.STRIP_PREFIX);
        monitoringConfigEntity.setKey(AppConstants.ZUUL_ROUTES_PREFIX + AppConstants.DOT + mappedParams.get("serviceId") + AppConstants.DOT + AppConstants.STRIP_PREFIX);
        monitoringConfigEntity.setValue(mappedParams.get("stripPrefix"));

        monitoringConfigService.saveMonitoringConfiguration(monitoringConfigEntity);

        monitoringConfigEntity.setConfigId(mappedParams.get("onboardId") + "_" + AppConstants.SERVICE_ID);
        monitoringConfigEntity.setKey(AppConstants.ZUUL_ROUTES_PREFIX + AppConstants.DOT + mappedParams.get("serviceId") + AppConstants.DOT + AppConstants.SERVICE_ID);
        monitoringConfigEntity.setValue(mappedParams.get("serviceId"));

        monitoringConfigService.saveMonitoringConfiguration(monitoringConfigEntity);


    }

}
