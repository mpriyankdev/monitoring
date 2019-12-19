package com.monitor.monitoringconfigsvc.controller;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.model.MonitoringConfigModel;
import com.monitor.monitoringconfigsvc.service.MonitoringConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class MonitoringConfigController {

    @Autowired
    private MonitoringConfigService monitoringConfigService;

    @PostMapping("/onboard")
    public ResponseEntity<MonitoringConfigEntity> onboardService(@RequestBody final MonitoringConfigModel monitoringConfigModel) {

        final MonitoringConfigEntity monitoringConfigEntity = monitoringConfigService.saveMonitoringConfiguration(monitoringConfigModel);
        return new ResponseEntity<>(monitoringConfigEntity, HttpStatus.ACCEPTED);

    }

    @GetMapping("/onboard/{configId}")
    public ResponseEntity<MonitoringConfigEntity> viewOnboardedService(@PathVariable("configId") final String configId) {

        final MonitoringConfigEntity monitoringConfigEntity = monitoringConfigService.viewMonitoringConfiguration(configId);
        return new ResponseEntity<>(monitoringConfigEntity, HttpStatus.OK);
    }
}
