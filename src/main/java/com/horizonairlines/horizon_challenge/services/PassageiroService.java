package com.horizonairlines.horizon_challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizonairlines.horizon_challenge.dtos.PassageiroDTO;
import com.horizonairlines.horizon_challenge.repositories.PassageiroRepository;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    public List<PassageiroDTO> findByVoo(Long id) {
        var passageiros = passageiroRepository.findByVoo(id);
        return passageiros.stream().map(x -> new PassageiroDTO(x)).toList();
    }

}
