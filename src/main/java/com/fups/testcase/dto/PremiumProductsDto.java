package com.fups.testcase.dto;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class PremiumProductsDto {
    private Long id;
    private String productTitle;
    private String productDescription;
    private String productImageUrl;
}
