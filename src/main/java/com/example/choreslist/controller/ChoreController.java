package com.example.choreslist.controller;

import com.example.choreslist.domain.entity.ChoreEntity;
import com.example.choreslist.services.ChoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chores")
public class ChoreController {
    @Autowired
    ChoreService choreService;

    @GetMapping("/util")
    public ResponseEntity<List<ChoreEntity>> getAllChores() {
        List<ChoreEntity> chores = choreService.getAllChores();
        if (chores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chores, HttpStatus.OK);
    }

//    @GetMapping("/util/{id}")
//    public ResponseEntity<ChoreEntity> getChoreById(@PathVariable("id") Long id) {
//        Optional<ChoreEntity> choreData = choreService.findById(id);
//
//        if (choreData.isPresent()) {
//            return new ResponseEntity<>(choreData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    @PostMapping
    public ResponseEntity<ChoreEntity> creatingChore(@Valid @RequestBody ChoreEntity chore) {
        ChoreEntity createdChore = choreService.addChore(chore);
        return new ResponseEntity<>(createdChore, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChoreEntity> updateChore(@PathVariable Long id, @Validated @RequestBody ChoreEntity chore) {
        Optional<ChoreEntity> choreData = choreService.getChoreById(id);

        if (choreData.isPresent()) {
            ChoreEntity choreEntity = choreData.get();
            choreEntity.setDescription(chore.getDescription());
            return new ResponseEntity<>(choreService.addChore(choreEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteChore(@PathVariable Long id) {
        try {
            choreService.deleteChore(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
