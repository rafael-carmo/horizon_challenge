package com.horizonairlines.horizon_challenge.dtos;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Classe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClasseUpdateDTO {

    private String tipo;
    private Integer qtdAssentos;
    private BigDecimal valor;

    public ClasseUpdateDTO(Classe entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
