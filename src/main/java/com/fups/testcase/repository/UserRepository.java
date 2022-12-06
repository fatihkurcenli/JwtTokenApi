package com.fups.testcase.repository;

import com.fups.testcase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);

}
