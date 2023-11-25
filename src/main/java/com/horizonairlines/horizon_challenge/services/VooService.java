package com.horizonairlines.horizon_challenge.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizonairlines.horizon_challenge.dtos.VooDTO;
import com.horizonairlines.horizon_challenge.dtos.VooInputDTO;
import com.horizonairlines.horizon_challenge.dtos.VooUpdateDTO;
import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Voo;
import com.horizonairlines.horizon_challenge.repositories.AeroportoRepository;
import com.horizonairlines.horizon_challenge.repositories.ClasseRepository;
import com.horizonairlines.horizon_challenge.repositories.VooRepository;

@Service
public class VooService {

    @Autowired
    private VooRepository vooRepository;
    @Autowired
    private AeroportoRepository aeroportoRepository;
    @Autowired
    private ClasseRepository classeRepository;

    public VooDTO save(VooInputDTO vooInputDto) {
        var voo = new Voo();

        var aeroportoOrigem = aeroportoRepository.findById(vooInputDto.getAeroporto_origem_id()).get();
        var aeroportoDestino = aeroportoRepository.findById(vooInputDto.getAeroporto_destino_id()).get();

        vooInputDto.setAeroportoOrigem(aeroportoOrigem);
        vooInputDto.setAeroportoDestino(aeroportoDestino);

        BeanUtils.copyProperties(vooInputDto, voo);

        Voo result = vooRepository.save(voo);

        Set<Classe> classeList = new HashSet<Classe>();
        vooInputDto.getClasses().forEach(classe -> {
            Voo vooTeste = new Voo();
            vooTeste.setId(result.getId());
            classe.setVoo(vooTeste);
            classeList.add(classeRepository.save(classe));
        });

        result.setClasses(classeList);

        return new VooDTO(result);
    }

    public VooDTO findById(Long id) {
        var voo = vooRepository.findById(id).get();
        return new VooDTO(voo);
    }

    public List<VooDTO> findAll() {
        List<Voo> voos = vooRepository.findAll();
        return voos.stream().map(x -> new VooDTO(x)).toList();
    }

    public VooDTO update(Long id, VooUpdateDTO vooUpdateDTO) {
        var voo = vooRepository.findById(id).get();

        var aeroportoOrigem = aeroportoRepository.findById(vooUpdateDTO.getAeroporto_origem_id()).get();
        var aeroportoDestino = aeroportoRepository.findById(vooUpdateDTO.getAeroporto_destino_id()).get();

        vooUpdateDTO.setAeroportoOrigem(aeroportoOrigem);
        vooUpdateDTO.setAeroportoDestino(aeroportoDestino);

        BeanUtils.copyProperties(vooUpdateDTO, voo);

        var result = vooRepository.save(voo);
        return new VooDTO(result);
    }

    public VooDTO cancelarVoo(Long id) {
        var voo = vooRepository.findById(id).get();
        voo.setCancelado(true);
        var result = vooRepository.save(voo);
        return new VooDTO(result);
    }

}
