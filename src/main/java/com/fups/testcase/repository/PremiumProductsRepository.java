package com.fups.testcase.repository;

import com.fups.testcase.entity.PremiumProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiumProductsRepository extends JpaRepository<PremiumProduct, Long> {
}
