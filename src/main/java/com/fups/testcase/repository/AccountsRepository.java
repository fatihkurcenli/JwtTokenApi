package com.fups.testcase.repository;

import com.fups.testcase.entity.menu.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
