package com.fups.testcase.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fups.testcase.exception.GenericException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {

//    @Value("${jwt-variable.KEY}")
//    private String KEY;
//
//    @Value("${jwt-variable.ISSUER}")
//    private String ISSUER;
//
//    @Value("${jwt-variable.EXPIRES_ACCESS_TOKEN_MINUTES}")
//    private long EXPIRES_ACCESS_TOKEN_MINUTES;


    private String KEY = "test";

    private String ISSUER = "test";

    private long EXPIRES_ACCESS_TOKEN_MINUTES = 15;


    public String generateToken(Authentication authentication) {
        String userName = ((UserDetails) authentication.getPrincipal()).getUsername();
        return JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis() + (EXPIRES_ACCESS_TOKEN_MINUTES * 60 * 1000)))
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }

    public DecodedJWT verifyJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(KEY.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            return verifier.verify(token);
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }
    }

}
