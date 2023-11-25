package com.horizonairlines.horizon_challenge.dtos;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Aeroporto;
import com.horizonairlines.horizon_challenge.entities.Cidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AeroportoMinDTO {

    private Long cidade_id;
    private Cidade cidade;
    private String nome;
    private String codigoIata;

    public AeroportoMinDTO(Aeroporto entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
