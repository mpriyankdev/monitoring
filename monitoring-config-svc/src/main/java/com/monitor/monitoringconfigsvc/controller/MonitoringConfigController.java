package com.monitor.monitoringconfigsvc.controller;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.service.MonitoringConfigService;
import com.monitor.monitoringconfigsvc.utility.MonitoringConfigUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class MonitoringConfigController {

    @Autowired
    private MonitoringConfigService monitoringConfigService;
    @Autowired
    private MonitoringConfigUtility monitoringConfigUtility;

    @PostMapping("/onboard")
    public ResponseEntity<MonitoringConfigEntity> onboardService(@RequestBody final MonitoringConfigEntity monitoringConfigEntity) {

        final MonitoringConfigEntity monitoringConfigEntitySaved = monitoringConfigService.saveMonitoringConfiguration(monitoringConfigEntity);
        return new ResponseEntity<>(monitoringConfigEntitySaved, HttpStatus.ACCEPTED);

    }

    @PostMapping("/onboard/map/")
    public ResponseEntity<Void> onboardServiceUsingMap(@RequestBody final Map<String, String> mappedParams) {

        System.out.println("mappedParams : " + mappedParams);
        monitoringConfigUtility.configCreator(mappedParams);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


    @GetMapping("/onboard/{configId}")
    public ResponseEntity<MonitoringConfigEntity> viewOnboardedService(@PathVariable("configId") final String configId) {

        final MonitoringConfigEntity monitoringConfigEntity = monitoringConfigService.viewMonitoringConfiguration(configId);
        return new ResponseEntity<>(monitoringConfigEntity, HttpStatus.OK);
    }
}
