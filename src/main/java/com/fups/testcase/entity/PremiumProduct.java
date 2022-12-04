package com.fups.testcase.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "premium_products")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class PremiumProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productTitle;
    private String productDescription;
    private String productImageUrl;
}
