package com.monitor.monitoringsvc.controller;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import com.monitor.monitoringsvc.model.OnboardDetails;
import com.monitor.monitoringsvc.service.OnboardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-monitor")
public class OnboardDetailsController {

    @Autowired
    private OnboardDetailsService onboardDetailsService;

    @PostMapping("/onboard")
    public ResponseEntity<OnboardDetailsEntity> onboardService(@RequestBody final OnboardDetails onboardDetails) {

        final OnboardDetailsEntity onboardDetailsEntity = onboardDetailsService.onboardService(onboardDetails);
        return new ResponseEntity<>(onboardDetailsEntity, HttpStatus.OK);

    }

    @GetMapping("/onboard/status/{onboardId}")
    public ResponseEntity<OnboardDetailsEntity> onboardServiceStatus(@PathVariable("onboardId") final String onboardId) {

        final OnboardDetailsEntity onboardDetailsEntity = onboardDetailsService.onboardServiceStatus(onboardId);
        return new ResponseEntity<>(onboardDetailsEntity, HttpStatus.OK);
    }


}
