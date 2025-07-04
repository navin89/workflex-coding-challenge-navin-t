package com.workflex.challenge.backend.repository;

import com.workflex.challenge.backend.model.Workation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkationRepository extends JpaRepository<Workation, Long> {
    // No extra methods needed, JpaRepository provides sorting
}