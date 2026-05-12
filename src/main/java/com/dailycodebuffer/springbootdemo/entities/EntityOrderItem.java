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
@Table(name = "order_items")
public class EntityOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private EntityOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private EntityProduct product;

    private Integer quantity;
    private BigDecimal unitPrice;
}