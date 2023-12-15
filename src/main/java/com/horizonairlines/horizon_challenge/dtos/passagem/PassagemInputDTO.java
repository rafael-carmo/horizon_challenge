package com.horizonairlines.horizon_challenge.dtos.passagem;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Passagem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PassagemInputDTO {

    private Long passageiro_id;
    private Long classe_id;
    private Long comprador_id;
    private Integer numero;
    private Boolean despachoBagagem;

    public PassagemInputDTO(Passagem entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
