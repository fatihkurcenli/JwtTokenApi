package com.fups.testcase.dto;

import com.fups.testcase.entity.RollType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class UserDto {
    private String email;
    private String userName;
    @Enumerated(EnumType.STRING)
    private RollType rollType;
}
