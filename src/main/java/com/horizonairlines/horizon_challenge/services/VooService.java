package com.horizonairlines.horizon_challenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horizonairlines.horizon_challenge.dtos.VooDTO;
import com.horizonairlines.horizon_challenge.dtos.VooInputDTO;
import com.horizonairlines.horizon_challenge.dtos.VooUpdateDTO;
import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Voo;
import com.horizonairlines.horizon_challenge.exceptions.AirportOrCityEqualsException;
import com.horizonairlines.horizon_challenge.exceptions.ClassVooNotFoundException;
import com.horizonairlines.horizon_challenge.exceptions.CodeUniqueExistsException;
import com.horizonairlines.horizon_challenge.exceptions.NotFoundException;
import com.horizonairlines.horizon_challenge.exceptions.ObjectAlreadyExistsException;
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

    @Transactional
    public VooDTO save(VooInputDTO vooInputDto) {
        var voo = new Voo();

        // REGRA: Voos devem ter numeração única
        var uniqueNumber = vooRepository.findByNumero(vooInputDto.getNumber());
        if (Objects.nonNull(uniqueNumber))
            throw new CodeUniqueExistsException("Número do voo já existe.");

        var aeroportoOrigem = aeroportoRepository.findById(vooInputDto.getAeroporto_origem_id())
                .orElseThrow(() -> new NotFoundException("Aeroporto origem não encontrado!"));

        var aeroportoDestino = aeroportoRepository.findById(vooInputDto.getAeroporto_destino_id())
                .orElseThrow(() -> new NotFoundException("Aeroporto destino não encontrado!"));

        // REGRA:O voo não pode ter como origem e destino o mesmo aeroporto, e esses
        // aeroportos não podem estar situados na mesma cidade.
        if (vooInputDto.getAeroporto_origem_id().equals(vooInputDto.getAeroporto_destino_id()) ||
                aeroportoOrigem.getCidade().getId().equals(aeroportoDestino.getCidade().getId()))
            throw new AirportOrCityEqualsException();

        // REGRA: Voos devem possuir pelo menos uma classe
        if (vooInputDto.getClasses().size() < 1) {
            throw new ClassVooNotFoundException();
        }

        voo.setAeroportoOrigem(aeroportoOrigem);
        voo.setAeroportoDestino(aeroportoDestino);

        BeanUtils.copyProperties(vooInputDto, voo);

        Voo result = vooRepository.save(voo);

        List<Classe> classeList = new ArrayList<Classe>();
        vooInputDto.getClasses().forEach(classe -> {
            Voo vooClasse = new Voo();
            vooClasse.setId(result.getId());
            classe.setVoo(vooClasse);

            // REGRA: Não deve haver duas ou mais
            // classes do mesmo tipo no mesmo voo.
            if (classeRepository.existsByTipoAndVoo(classe.getTipo(), result))
                throw new ObjectAlreadyExistsException(
                        "Não deve haver duas ou mais classes do mesmo tipo no mesmo voo.");

            classeList.add(classeRepository.save(classe));
        });

        result.setClasses(classeList);

        return new VooDTO(result);
    }

    public VooDTO findById(Long id) {
        var voo = vooRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Voo não encontrado!"));
        return new VooDTO(voo);
    }

    public List<VooDTO> findAll() {
        List<Voo> voos = vooRepository.findAll();
        return voos.stream().map(x -> new VooDTO(x)).toList();
    }

    public VooDTO update(Long id, VooUpdateDTO vooUpdateDTO) {
        var voo = vooRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Voo não encontrado!"));

        var aeroportoOrigem = aeroportoRepository.findById(vooUpdateDTO.getAeroporto_origem_id())
                .orElseThrow(() -> new NotFoundException("Aeroporto origem não encontrado!"));

        var aeroportoDestino = aeroportoRepository.findById(vooUpdateDTO.getAeroporto_destino_id())
                .orElseThrow(() -> new NotFoundException("Aeroporto destino não encontrado!"));

        voo.setAeroportoOrigem(aeroportoOrigem);
        voo.setAeroportoDestino(aeroportoDestino);

        BeanUtils.copyProperties(vooUpdateDTO, voo);

        var result = vooRepository.save(voo);
        return new VooDTO(result);
    }

    public VooDTO cancelarVoo(Long id) {
        var voo = vooRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Voo não encontrado!"));
        ;
        voo.setCancelado(true);
        var result = vooRepository.save(voo);
        return new VooDTO(result);
    }

}
