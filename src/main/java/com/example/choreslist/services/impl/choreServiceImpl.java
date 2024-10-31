package com.example.choreslist.services.impl;
import com.example.choreslist.domain.entity.ChoreEntity;
import com.example.choreslist.repository.ChoreRepository;
import com.example.choreslist.services.ChoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class choreServiceImpl implements ChoreService {
        @Autowired
        private ChoreRepository choreRepository;

        public List<ChoreEntity> getAllChores() {
            return choreRepository.findAll();
        }

        public Optional<ChoreEntity> getChoreById(Long id) {
            return choreRepository.findById(id);
        }

        public ChoreEntity addChore(ChoreEntity choreEntity) {
            return choreRepository.save(choreEntity);
        }

        public ChoreEntity updateChore(Long id, String description) {
            ChoreEntity choreEntity = choreRepository.findById(id).orElseThrow(() -> new RuntimeException("A chore with such an id was not found"));
            choreEntity.setDescription(description);
            return choreRepository.save(choreEntity);
        }

        public void deleteChore(Long id) {
            ChoreEntity choreEntity = choreRepository.findById(id).orElseThrow(() -> new RuntimeException("A chore with such an id was not found"));
            choreRepository.delete(choreEntity);
        }
}

