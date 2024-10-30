package com.dn.expense_tracker.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(
    uniqueConstraints = @UniqueConstraint(
            name = "name_unique",
            columnNames = "name"
    )
)
public class ExpenseSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseSourceId;
    @Column(
            nullable = false
    )
    private String name;
    private double budget;

}
