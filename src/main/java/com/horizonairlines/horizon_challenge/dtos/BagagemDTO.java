package com.horizonairlines.horizon_challenge.dtos;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Bagagem;
import com.horizonairlines.horizon_challenge.entities.Passagem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BagagemDTO {

    private Long id;
    private Passagem passagem;
    private Integer numero;

    public BagagemDTO(Bagagem entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
