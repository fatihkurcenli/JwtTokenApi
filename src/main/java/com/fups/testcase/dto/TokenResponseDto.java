package com.fups.testcase.dto;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class TokenResponseDto {
    private String accessToken;
    private UserDto userDto;
}
