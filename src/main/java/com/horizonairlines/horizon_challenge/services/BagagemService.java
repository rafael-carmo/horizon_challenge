package com.horizonairlines.horizon_challenge.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizonairlines.horizon_challenge.dtos.EtiquetaDTO;
import com.horizonairlines.horizon_challenge.exceptions.NotFoundException;
import com.horizonairlines.horizon_challenge.repositories.BagagemRepository;

@Service
public class BagagemService {

    @Autowired
    private BagagemRepository bagagemRepository;

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
