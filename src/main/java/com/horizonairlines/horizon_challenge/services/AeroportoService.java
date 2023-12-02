package com.horizonairlines.horizon_challenge.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizonairlines.horizon_challenge.dtos.AeroportoDTO;
import com.horizonairlines.horizon_challenge.dtos.AeroportoMinDTO;
import com.horizonairlines.horizon_challenge.entities.Aeroporto;
import com.horizonairlines.horizon_challenge.exceptions.CodeUniqueExistsException;
import com.horizonairlines.horizon_challenge.repositories.AeroportoRepository;
import com.horizonairlines.horizon_challenge.repositories.CidadeRepository;

@Service
public class AeroportoService {

    @Autowired
    private AeroportoRepository aeroportoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public AeroportoDTO save(AeroportoMinDTO aeroportoMinDto) {
        var aeroporto = new Aeroporto();

        var aeroportoIata = aeroportoRepository.findByCodigoIata(aeroportoMinDto.getCodigoIata());
        if (aeroportoIata != null)
            throw new CodeUniqueExistsException("Já existe aeroporto com este código IATA.");

        var cidade = cidadeRepository.findById(aeroportoMinDto.getCidade_id()).get();
        aeroportoMinDto.setCidade(cidade);

        BeanUtils.copyProperties(aeroportoMinDto, aeroporto);
        Aeroporto result = aeroportoRepository.save(aeroporto);
        return new AeroportoDTO(result);
    }

    public AeroportoDTO findById(Long id) {
        var aeroporto = aeroportoRepository.findById(id).get();
        return new AeroportoDTO(aeroporto);
    }

    public List<AeroportoDTO> findAll() {
        List<Aeroporto> aeroportos = aeroportoRepository.findAll();
        return aeroportos.stream().map(x -> new AeroportoDTO(x)).toList();
    }

}
