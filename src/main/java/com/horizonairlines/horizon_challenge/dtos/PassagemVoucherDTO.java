package com.horizonairlines.horizon_challenge.dtos;

import com.horizonairlines.horizon_challenge.projections.VoucherProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PassagemVoucherDTO {

    private Integer numeroPassagem;
    private Integer numeroVoo;
    private String nomeAeroportoOrigem;
    private String nomeAeroportoDestino;
    private String nomePassageiro;
    private String cpfPassageiro;
    private Boolean despachoBagagem;

    public PassagemVoucherDTO(VoucherProjection projection) {
        numeroPassagem = projection.getNumeroPassagem();
        numeroVoo = projection.getNumeroVoo();
        nomeAeroportoOrigem = projection.getNomeAeroportoOrigem();
        nomeAeroportoDestino = projection.getNomeAeroportoDestino();
        nomePassageiro = projection.getNomePassageiro();
        cpfPassageiro = projection.getCpfPassageiro();
        despachoBagagem = projection.getDespachoBagagem();
    }

}
