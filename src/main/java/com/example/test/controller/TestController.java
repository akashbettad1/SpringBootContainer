package com.example.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final String message = "Welcome Controller";

    @GetMapping("/sayWelcome")
    public ResponseEntity<String> sayWelcome() {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
