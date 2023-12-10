package com.horizonairlines.horizon_challenge.dtos;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Voo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClasseDTO {

    private Long id;
    private Voo voo;
    private String tipo;
    private Integer qtdAssentos;
    private BigDecimal valor;

    public ClasseDTO(Classe entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
