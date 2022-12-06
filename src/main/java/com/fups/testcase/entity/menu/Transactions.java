package com.fups.testcase.entity.menu;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}