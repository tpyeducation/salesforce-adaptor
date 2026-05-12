package com.dailycodebuffer.springbootdemo.repository;

import com.dailycodebuffer.springbootdemo.entities.EntityTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<EntityTask, Long> {
}