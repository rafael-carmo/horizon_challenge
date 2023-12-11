package com.horizonairlines.horizon_challenge.dtos;

import com.horizonairlines.horizon_challenge.projections.EtiquetaProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EtiquetaDTO {

    private Integer numeroPassagem;
    private Integer numeroBagagem;
    private String nomePassageiro;

    public EtiquetaDTO(EtiquetaProjection projection) {
        numeroPassagem = projection.getNumeroPassagem();
        numeroBagagem = projection.getNumeroBagagem();
        nomePassageiro = projection.getNomePassageiro();
    }

}
