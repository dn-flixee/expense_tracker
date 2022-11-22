package com.dn.expense_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "name_unique",
                columnNames = "name"
        )
)
public class IncomeSource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long incomeSourceId;
    private String name;
    private Double goal;
}
