package com.monitor.monitoringsvc.controller;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import com.monitor.monitoringsvc.model.OnboardDetails;
import com.monitor.monitoringsvc.service.OnboardDetailsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-monitor")
public class OnboardDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitoredSvcStatusController.class);

    @Autowired
    private OnboardDetailsService onboardDetailsService;

    @PostMapping("/onboard")
    @ApiOperation("Onboard the service details which needs to be monitored")
    public ResponseEntity<OnboardDetailsEntity> onboardService(@RequestBody final OnboardDetails onboardDetails) {

        LOGGER.info("Onboarding details for {}", onboardDetails.getServiceName());
        final OnboardDetailsEntity onboardDetailsEntity = onboardDetailsService.onboardService(onboardDetails);
        return new ResponseEntity<>(onboardDetailsEntity, HttpStatus.OK);

    }

    @GetMapping("/onboard/status/{onboardId}")
    @ApiOperation("Check the onboarded details using the service-name")
    public ResponseEntity<OnboardDetailsEntity> onboardServiceStatus(@PathVariable("serviceName") final String serviceName) {

        final OnboardDetailsEntity onboardDetailsEntity = onboardDetailsService.onboardServiceStatus(serviceName);
        return new ResponseEntity<>(onboardDetailsEntity, HttpStatus.OK);
    }


}
