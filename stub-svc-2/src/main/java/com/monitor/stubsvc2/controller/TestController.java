package com.monitor.stubsvc2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stub2")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hello from stub-svc-2", HttpStatus.OK);
    }
}

