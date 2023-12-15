package com.horizonairlines.horizon_challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horizonairlines.horizon_challenge.dtos.bagagem.BagagemDTO;
import com.horizonairlines.horizon_challenge.dtos.bagagem.BagagemInputDTO;
import com.horizonairlines.horizon_challenge.dtos.bagagem.EtiquetaDTO;
import com.horizonairlines.horizon_challenge.services.BagagemService;

@RestController
@RequestMapping(value = "/bagagens")
public class BagagemController {

    @Autowired
    private BagagemService bagagemService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BagagemDTO> findById(@PathVariable Long id) {
        BagagemDTO result = bagagemService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<BagagemDTO> save(@RequestBody BagagemInputDTO bagagemInputDTO) {
        var result = bagagemService.save(bagagemInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<EtiquetaDTO> printEtiqueta(@RequestParam Integer numero) {
        var result = bagagemService.printEtiqueta(numero);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
