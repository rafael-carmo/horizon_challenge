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

import com.horizonairlines.horizon_challenge.dtos.VooDTO;
import com.horizonairlines.horizon_challenge.dtos.VooInputDTO;
import com.horizonairlines.horizon_challenge.dtos.VooUpdateDTO;
import com.horizonairlines.horizon_challenge.services.VooService;

@RestController
@RequestMapping(value = "/voos")
public class VooController {

    @Autowired
    private VooService vooService;

    @PostMapping
    public ResponseEntity<VooDTO> saveVoo(@RequestBody VooInputDTO vooInputDTO) {
        VooDTO result = vooService.save(vooInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VooDTO> findById(@PathVariable Long id) {
        VooDTO result = vooService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<VooDTO>> findAll() {
        List<VooDTO> resultList = vooService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(resultList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VooDTO> updateVoo(@PathVariable Long id, @RequestBody VooUpdateDTO vooUpdateDTO) {
        VooDTO result = vooService.update(id, vooUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping(value = "/{id}/cancelar")
    public ResponseEntity<VooDTO> cancelarVoo(@PathVariable Long id) {
        VooDTO result = vooService.cancelarVoo(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
