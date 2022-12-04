package com.fups.testcase.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class LoginRequest {
    private String userName;
    private String email;
    private String password;
}
