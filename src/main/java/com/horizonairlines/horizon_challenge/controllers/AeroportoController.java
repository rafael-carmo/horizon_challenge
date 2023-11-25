package com.horizonairlines.horizon_challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horizonairlines.horizon_challenge.dtos.AeroportoDTO;
import com.horizonairlines.horizon_challenge.dtos.AeroportoMinDTO;
import com.horizonairlines.horizon_challenge.services.AeroportoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoService aeroportoService;

    @PostMapping
    public ResponseEntity<AeroportoDTO> saveAeroporto(@RequestBody AeroportoMinDTO aeroportoMinDTO) {
        AeroportoDTO result = aeroportoService.save(aeroportoMinDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AeroportoDTO> findById(@PathVariable Long id) {
        AeroportoDTO result = aeroportoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<AeroportoDTO>> findAll() {
        List<AeroportoDTO> resultList = aeroportoService.findAll();
        System.out.println("Lista de aeroportos");
        System.out.println(resultList.size());
        return ResponseEntity.status(HttpStatus.OK).body(resultList);
    }

}
