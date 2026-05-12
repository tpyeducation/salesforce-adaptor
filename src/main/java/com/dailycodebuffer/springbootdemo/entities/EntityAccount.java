package com.dailycodebuffer.springbootdemo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "accounts")
public class EntityAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String industry;

    @Column(name = "annual_revenue")
    private BigDecimal annualRevenue;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<EntityContact> contacts;

    @OneToMany(mappedBy = "account")
    private List<EntityOrder> orders;
}