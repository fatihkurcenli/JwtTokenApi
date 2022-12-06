package com.fups.testcase.controller;

import com.fups.testcase.service.PremiumProductsServices;
import com.fups.testcase.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/premium")
public class PremiumController {

    private final PremiumProductsServices productsServices;
    private final UserService userService;

    public PremiumController(PremiumProductsServices productsServices, UserService userService) {
        this.productsServices = productsServices;
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<?> getPremiumProducts() {
        return productsServices.allProductsPremium();
    }

    @GetMapping("/me")
    String getMe() {
        String userName = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return userName;
    }

    @GetMapping("/me-detail")
    ResponseEntity<?> getMeDetail() {
        String userName = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return ResponseEntity.ok(userService.getUser(userName));
    }

}
