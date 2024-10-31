package com.example.choreslist.services;

import com.example.choreslist.domain.entity.ChoreEntity;

import java.util.List;
import java.util.Optional;

public interface ChoreService {
    public List<ChoreEntity> getAllChores();
    public Optional<ChoreEntity> getChoreById(Long id);
    public ChoreEntity addChore(ChoreEntity choreEntity);
    public ChoreEntity updateChore(Long id, String description);
    public void deleteChore(Long id);
}
