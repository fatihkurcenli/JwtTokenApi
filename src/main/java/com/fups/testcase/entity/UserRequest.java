package com.fups.testcase.entity;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String nameAndSurname;
    private String email;
    private String password;
    private RollType rollType;
}
