package com.monitor.monitoringsvc.utility;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import com.monitor.monitoringsvc.mapper.OnboardDetailsEntityToMonitoringConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OnboardDetailsUtility {

    //make a rest call to create the configs in monitoring-config-svc
    //create a method that converts the onboardDetails to the configurations needed
    //also on successfull creation of a parameter , hit the refresh endpoint to refresh the configuration

    @Autowired
    private OnboardDetailsEntityToMonitoringConfigMapper onboardDetailsEntityToMonitoringConfigMapper;
    @Autowired
    private MonitoringHttpClient monitoringHttpClient;

    public void onboard(final OnboardDetailsEntity onboardDetailsEntity) {

        final Map<String, String> paramsMap = onboardDetailsEntityToMonitoringConfigMapper.map(onboardDetailsEntity);
        monitoringHttpClient.componentsBuilder(paramsMap);


    }


}
