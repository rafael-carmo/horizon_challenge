package com.horizonairlines.horizon_challenge.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizonairlines.horizon_challenge.dtos.AeroportoDTO;
import com.horizonairlines.horizon_challenge.dtos.AeroportoMinDTO;
import com.horizonairlines.horizon_challenge.dtos.PassageiroDTO;
import com.horizonairlines.horizon_challenge.entities.Aeroporto;
import com.horizonairlines.horizon_challenge.projections.PassageiroProjection;
import com.horizonairlines.horizon_challenge.repositories.AeroportoRepository;
import com.horizonairlines.horizon_challenge.repositories.CidadeRepository;
import com.horizonairlines.horizon_challenge.repositories.PassageiroRepository;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    // public AeroportoDTO save(AeroportoMinDTO aeroportoMinDto) {
    // var aeroporto = new Aeroporto();

    // var cidade = cidadeRepository.findById(aeroportoMinDto.getCidade_id()).get();
    // aeroportoMinDto.setCidade(cidade);

    // BeanUtils.copyProperties(aeroportoMinDto, aeroporto);
    // Aeroporto result = aeroportoRepository.save(aeroporto);
    // return new AeroportoDTO(result);
    // }

    // public AeroportoDTO findById(Long id) {
    // var aeroporto = aeroportoRepository.findById(id).get();
    // return new AeroportoDTO(aeroporto);
    // }

    // public List<AeroportoDTO> findAll() {
    // List<Aeroporto> aeroportos = aeroportoRepository.findAll();
    // return aeroportos.stream().map(x -> new AeroportoDTO(x)).toList();
    // }

    public List<PassageiroDTO> findByVoo(Long id) {
        var passageiros = passageiroRepository.findByVoo(id);
        return passageiros.stream().map(x -> new PassageiroDTO(x)).toList();
    }

}
