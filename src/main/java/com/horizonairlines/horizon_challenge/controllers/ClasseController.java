package com.horizonairlines.horizon_challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horizonairlines.horizon_challenge.dtos.classe.ClasseDTO;
import com.horizonairlines.horizon_challenge.dtos.classe.ClasseInputDTO;
import com.horizonairlines.horizon_challenge.dtos.classe.ClasseUpdateDTO;
import com.horizonairlines.horizon_challenge.services.ClasseService;

@RestController
@RequestMapping(value = "/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @PostMapping
    public ResponseEntity<ClasseDTO> saveClasse(@RequestBody ClasseInputDTO classeInputDTO) {
        ClasseDTO result = classeService.save(classeInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClasseDTO> findById(@PathVariable Long id) {
        ClasseDTO result = classeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> findAll() {
        List<ClasseDTO> resultList = classeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(resultList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClasseDTO> updateClasse(@PathVariable Long id, @RequestBody ClasseUpdateDTO classeUpdateDTO) {
        ClasseDTO result = classeService.update(id, classeUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
