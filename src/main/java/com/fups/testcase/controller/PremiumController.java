package com.fups.testcase.controller;

import com.fups.testcase.service.PremiumProductsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/premium")
public class PremiumController {

    private final PremiumProductsServices productsServices;

    public PremiumController(PremiumProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    @GetMapping
    ResponseEntity<?> getPremiumProducts() {
        return productsServices.allProductsPremium();
    }

}
