package com.monitor.monitoringsvc.controller;

import com.monitor.monitoringsvc.model.Registration;
import com.monitor.monitoringsvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<Registration> registerService(@RequestBody final Registration registration) {

        final Registration registeredService = registrationService.registerService(registration);
        return new ResponseEntity<>(registeredService, HttpStatus.ACCEPTED);

    }

    @GetMapping("/register/status")
    public ResponseEntity<List<Object>> registeredSvcStatus() {
        //todo : return back all the services along with their status
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);

    }


}
