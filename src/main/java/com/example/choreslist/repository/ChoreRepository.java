package com.example.choreslist.repository;

import com.example.choreslist.domain.entity.ChoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoreRepository extends JpaRepository<ChoreEntity, Long> {
}
