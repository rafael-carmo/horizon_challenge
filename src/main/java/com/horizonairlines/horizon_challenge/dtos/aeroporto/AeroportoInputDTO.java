package com.horizonairlines.horizon_challenge.dtos.Aeroporto;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Aeroporto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AeroportoInputDTO {

    private Long cidade_id;
    private String nome;
    private String codigoIata;

    public AeroportoInputDTO(Aeroporto entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
