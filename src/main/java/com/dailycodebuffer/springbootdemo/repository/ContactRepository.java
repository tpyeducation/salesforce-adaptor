package com.dailycodebuffer.springbootdemo.repository;

import com.dailycodebuffer.springbootdemo.entities.EntityContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<EntityContact, Long> {
}