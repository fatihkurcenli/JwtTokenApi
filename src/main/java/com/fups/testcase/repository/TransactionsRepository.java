package com.fups.testcase.repository;

import com.fups.testcase.entity.menu.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
