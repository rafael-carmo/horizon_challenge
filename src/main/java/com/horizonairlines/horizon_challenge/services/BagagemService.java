package com.horizonairlines.horizon_challenge.services;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horizonairlines.horizon_challenge.dtos.BagagemDTO;
import com.horizonairlines.horizon_challenge.dtos.BagagemInputDTO;
import com.horizonairlines.horizon_challenge.dtos.EtiquetaDTO;
import com.horizonairlines.horizon_challenge.entities.Bagagem;
import com.horizonairlines.horizon_challenge.exceptions.CodeUniqueExistsException;
import com.horizonairlines.horizon_challenge.exceptions.NotFoundException;
import com.horizonairlines.horizon_challenge.repositories.BagagemRepository;
import com.horizonairlines.horizon_challenge.repositories.PassagemRepository;

@Service
public class BagagemService {

    @Autowired
    private BagagemRepository bagagemRepository;

    @Autowired
    private PassagemRepository passagemRepository;

    public BagagemDTO findById(Long id) {
        var bagagem = bagagemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bagagem não encontrada!"));

        return new BagagemDTO(bagagem);
    }

    @Transactional
    public BagagemDTO save(BagagemInputDTO bagagemInputDto) {

        var passagem = passagemRepository.findById(bagagemInputDto.getPassagem_id()).get();
        if (Objects.isNull(passagem))
            throw new NotFoundException("Passagem não encontrada!");

        if (bagagemRepository.existsByNumero(bagagemInputDto.getNumero()))
            throw new CodeUniqueExistsException("Já existe uma bagagem com este número.");

        var bagagem = new Bagagem();
        bagagem.setPassagem(passagem);

        BeanUtils.copyProperties(bagagemInputDto, bagagem);

        Bagagem result = bagagemRepository.save(bagagem);

        return new BagagemDTO(result);
    }

    // public List<EtiquetaDTO> printEtiquetasByPassaem(Long passagem_id) {
    // var etiquetas = bagagemRepository.findEtiquetaByPassagem(passagem_id);
    // return etiquetas.stream().map(x -> new EtiquetaDTO(x)).toList();
    // }

    public EtiquetaDTO printEtiqueta(Integer numero) {
        var etiquetaProjection = bagagemRepository.findEtiquetaByNumero(numero);

        if (Objects.isNull(etiquetaProjection))
            throw new NotFoundException("Não existe bagagem com esta numeração!");

        return new EtiquetaDTO(etiquetaProjection);
    }

}
