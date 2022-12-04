package com.fups.testcase.controller;

import com.fups.testcase.entity.User;
import com.fups.testcase.entity.UserRequest;
import com.fups.testcase.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("status")
    ResponseEntity<?> getStatus() {
        return ResponseEntity.status(HttpStatus.OK).body("Status running server");
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getByUserId(@PathVariable Long id) {
        User getUser = userService.getUserProfile(id);
        if (getUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(getUser);
        } else {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping()
    ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) {
        User getUser = userService.addUser(userRequest);
        if (getUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(getUser);
        } else {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
}