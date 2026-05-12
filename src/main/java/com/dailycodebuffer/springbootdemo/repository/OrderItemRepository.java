package com.dailycodebuffer.springbootdemo.repository;

import com.dailycodebuffer.springbootdemo.entities.EntityOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<EntityOrderItem, Long> {
}