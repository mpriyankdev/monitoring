package com.monitor.monitoringsvc.controller;

import com.monitor.monitoringsvc.model.Registration;
import com.monitor.monitoringsvc.service.RegistrationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-monitor")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    @ApiOperation("after onboarding service register the service and enable the monitoring")
    public ResponseEntity<Registration> registerService(@RequestBody final Registration registration) {

        final Registration registeredService = registrationService.registerService(registration);
        return new ResponseEntity<>(registeredService, HttpStatus.ACCEPTED);

    }

}
