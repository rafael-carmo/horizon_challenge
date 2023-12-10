package com.horizonairlines.horizon_challenge.projections;

public interface VoucherProjection {

    Integer getNumeroPassagem();

    Integer getNumeroVoo();

    String getNomeAeroportoOrigem();

    String getNomeAeroportoDestino();

    String getNomePassageiro();

    String getCpfPassageiro();

    Boolean getDespachoBagagem();

}
