package com.fups.testcase.service;

import com.fups.testcase.dto.UserDto;
import com.fups.testcase.entity.User;
import com.fups.testcase.entity.UserRequest;
import com.fups.testcase.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserProfile(Long id) {
        return userRepository.findById(id).orElseThrow();
    }


    public User addUser(UserRequest userRequest) {
        User user = userRepository.save(User.builder()
                .userName(userRequest.getNameAndSurname())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .rollType(userRequest.getRollType())
                .build());
        System.out.println(user.getId());
        return user;
    }

    public UserDto getUser(String userName) {
        var savedUser = findByUserName(userName);
        return UserDto.builder()
                .email(savedUser.getEmail())
                .userName(savedUser.getUserName())
                .rollType(savedUser.getRollType()).build();
    }


    public User findByUserName(String name) {
        Optional<User> user = userRepository.findUserByUserName(name);
        return user.get();
    }
}
