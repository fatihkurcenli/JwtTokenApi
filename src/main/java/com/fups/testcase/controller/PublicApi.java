package com.fups.testcase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicApi {

    @GetMapping("/public")
    ResponseEntity<?> publicResponse() {
        return ResponseEntity.ok("this is public api");
    }
}
