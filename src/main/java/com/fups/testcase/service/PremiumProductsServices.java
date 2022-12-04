package com.fups.testcase.service;

import com.fups.testcase.entity.PremiumProduct;
import com.fups.testcase.repository.PremiumProductsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiumProductsServices {

    private final PremiumProductsRepository premiumRepository;

    public PremiumProductsServices(PremiumProductsRepository premiumRepository) {
        this.premiumRepository = premiumRepository;
    }


    public ResponseEntity<List<PremiumProduct>> allProductsPremium() {
        List<PremiumProduct> productList = premiumRepository.findAll();
        return ResponseEntity.ok(productList);
    }


    public void savePremiumProducts(PremiumProduct premiumProduct) {
        premiumRepository.save(premiumProduct);
    }
}
