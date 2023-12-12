package com.horizonairlines.horizon_challenge.dtos;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Bagagem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BagagemInputDTO {

    private Long passagem_id;
    private Integer numero;

    public BagagemInputDTO(Bagagem entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
