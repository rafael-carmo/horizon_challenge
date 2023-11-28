package com.horizonairlines.horizon_challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horizonairlines.horizon_challenge.dtos.PassageiroDTO;
import com.horizonairlines.horizon_challenge.services.PassageiroService;

@RestController
@RequestMapping(value = "/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @GetMapping
    public ResponseEntity<List<PassageiroDTO>> findByVoo(@RequestParam Long voo_id) {
        var result = passageiroService.findByVoo(voo_id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // @PostMapping
    // public ResponseEntity<AeroportoDTO> saveAeroporto(@RequestBody
    // AeroportoMinDTO aeroportoMinDTO) {
    // AeroportoDTO result = aeroportoService.save(aeroportoMinDTO);
    // return ResponseEntity.status(HttpStatus.CREATED).body(result);
    // }

    // @GetMapping(value = "/{id}")
    // public ResponseEntity<AeroportoDTO> findById(@PathVariable Long id) {
    // AeroportoDTO result = aeroportoService.findById(id);
    // return ResponseEntity.status(HttpStatus.OK).body(result);
    // }

    // @GetMapping
    // public ResponseEntity<List<AeroportoDTO>> findAll() {
    // List<AeroportoDTO> resultList = aeroportoService.findAll();
    // System.out.println("Lista de aeroportos");
    // System.out.println(resultList.size());
    // return ResponseEntity.status(HttpStatus.OK).body(resultList);
    // }

}
