package com.dailycodebuffer.springbootdemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "pricebook_entries")
public class EntityPricebookEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pricebook_id")
    private EntityPricebook pricebook;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private EntityProduct product;

    private BigDecimal unitPrice;
}