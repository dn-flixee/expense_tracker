package com.dn.expense_tracker.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(
    uniqueConstraints = @UniqueConstraint(
            name = "name_unique",
            columnNames = "name"
    )
)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(
            nullable = false
    )
    private String name;
    private double startingBalance;
    private Double type;
}
