package com.fups.testcase.service;


import com.fups.testcase.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        var roles = Stream.of(user.getRollType())
                .map(x -> new SimpleGrantedAuthority(x.name()))
                .collect(Collectors.toList());
        return
                new org.springframework.security.core.userdetails.
                        User(user.getUserName(), user.getPassword(), roles);
    }
}
