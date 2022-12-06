package com.fups.testcase.entity.menu;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "campaigns")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Campaigns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}
