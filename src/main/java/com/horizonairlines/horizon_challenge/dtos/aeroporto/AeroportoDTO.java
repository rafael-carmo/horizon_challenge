package com.horizonairlines.horizon_challenge.dtos.Aeroporto;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Aeroporto;
import com.horizonairlines.horizon_challenge.entities.Cidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AeroportoDTO {

    private Long id;
    private Cidade cidade;
    private String nome;
    private String codigoIata;

    public AeroportoDTO(Aeroporto entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
