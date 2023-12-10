package com.horizonairlines.horizon_challenge.controllers;

import java.util.List;

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

import com.horizonairlines.horizon_challenge.dtos.PassagemDTO;
import com.horizonairlines.horizon_challenge.dtos.PassagemInputDTO;
import com.horizonairlines.horizon_challenge.dtos.PassagemVoucherDTO;
import com.horizonairlines.horizon_challenge.services.PassagemService;

@RestController
@RequestMapping(value = "/passagens")
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @GetMapping
    public ResponseEntity<List<PassagemDTO>> findByCpf(@RequestParam String cpf) {
        var result = passagemService.findByCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/{id}/cancelar")
    public ResponseEntity<PassagemDTO> cancelarPassagem(@PathVariable Long id) {
        PassagemDTO result = passagemService.cancelarPassagem(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<PassagemDTO> save(@RequestBody PassagemInputDTO passagemInputDTO) {
        var result = passagemService.save(passagemInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{id}/voucher")
    public ResponseEntity<PassagemVoucherDTO> voucher(@PathVariable long id) {
        var result = passagemService.printVoucher(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
