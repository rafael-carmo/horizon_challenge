package com.horizonairlines.horizon_challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizonairlines.horizon_challenge.dtos.PassagemDTO;
import com.horizonairlines.horizon_challenge.repositories.PassagemRepository;

@Service
public class PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;

    public List<PassagemDTO> findByCpf(String cpf) {
        var passagens = passagemRepository.findByCpf(cpf);
        return passagens.stream().map(x -> new PassagemDTO(x)).toList();
    }

    public PassagemDTO cancelarPassagem(Long id) {
        var passagem = passagemRepository.findById(id).get();
        passagem.setCancelada(true);
        var result = passagemRepository.save(passagem);
        return new PassagemDTO(result);
    }

    public List<PassagemDTO> findAll() {
        var passagens = passagemRepository.findAll();
        return passagens.stream().map(x -> new PassagemDTO(x)).toList();
    }

}
