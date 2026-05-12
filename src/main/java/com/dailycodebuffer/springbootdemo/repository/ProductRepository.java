package com.dailycodebuffer.springbootdemo.repository;

import com.dailycodebuffer.springbootdemo.entities.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<EntityProduct, Long> {
}