package com.horizonairlines.horizon_challenge.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizonairlines.horizon_challenge.dtos.ClasseDTO;
import com.horizonairlines.horizon_challenge.dtos.ClasseInputDTO;
import com.horizonairlines.horizon_challenge.dtos.ClasseUpdateDTO;
import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.repositories.ClasseRepository;
import com.horizonairlines.horizon_challenge.repositories.VooRepository;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private VooRepository vooRepository;

    public ClasseDTO save(ClasseInputDTO classeInputDto) {
        var classe = new Classe();

        var voo = vooRepository.findById(classeInputDto.getVoo_id()).get();

        classeInputDto.setVoo(voo);

        BeanUtils.copyProperties(classeInputDto, classe);

        Classe result = classeRepository.save(classe);

        return new ClasseDTO(result);
    }

    public ClasseDTO findById(Long id) {
        var classe = classeRepository.findById(id).get();
        return new ClasseDTO(classe);
    }

    public List<ClasseDTO> findAll() {
        List<Classe> classes = classeRepository.findAll();
        return classes.stream().map(x -> new ClasseDTO(x)).toList();
    }

    public ClasseDTO update(Long id, ClasseUpdateDTO classeUpdateDTO) {
        var classe = classeRepository.findById(id).get();

        BeanUtils.copyProperties(classeUpdateDTO, classe);

        var result = classeRepository.save(classe);
        return new ClasseDTO(result);
    }

}
