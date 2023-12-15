package com.horizonairlines.horizon_challenge.dtos.passagem;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Comprador;
import com.horizonairlines.horizon_challenge.entities.Passageiro;
import com.horizonairlines.horizon_challenge.entities.Passagem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PassagemDTO {

    private Long id;
    private Passageiro passageiro;
    private Classe classe;
    private Comprador comprador;
    private Integer numero;
    private BigDecimal preco;
    private Boolean cancelada;
    private Boolean despachoBagagem;

    public PassagemDTO(Passagem entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
