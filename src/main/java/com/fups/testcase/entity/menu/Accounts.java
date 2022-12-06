package com.fups.testcase.entity.menu;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}
