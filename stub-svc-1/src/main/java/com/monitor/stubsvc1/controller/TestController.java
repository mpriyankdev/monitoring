package com.monitor.stubsvc1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stub1")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> test200() {
        return new ResponseEntity<>("hello from stub-svc-1", HttpStatus.OK);
    }

    @GetMapping("/hello_ACCEPTED")
    public ResponseEntity<String> test_accepted() {
        return new ResponseEntity<>("hello from stub-svc-1", HttpStatus.ACCEPTED);
    }

    @GetMapping("/hello_NOCONTENT")
    public ResponseEntity<String> test_nocontent() {
        return new ResponseEntity<>("hello from stub-svc-1", HttpStatus.NO_CONTENT);
    }
}
