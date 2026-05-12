package com.dailycodebuffer.springbootdemo.repository;

import com.dailycodebuffer.springbootdemo.entities.EntityAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<EntityAccount, Long> {
}