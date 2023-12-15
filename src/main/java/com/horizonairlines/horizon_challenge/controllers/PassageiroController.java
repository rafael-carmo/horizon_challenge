package com.horizonairlines.horizon_challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horizonairlines.horizon_challenge.dtos.passageiro.PassageiroDTO;
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

}
