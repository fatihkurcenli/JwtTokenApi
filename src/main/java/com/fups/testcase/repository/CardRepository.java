package com.fups.testcase.repository;

import com.fups.testcase.entity.menu.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Cards, Long> {
}
