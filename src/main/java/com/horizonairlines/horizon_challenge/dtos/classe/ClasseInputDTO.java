package com.horizonairlines.horizon_challenge.dtos.classe;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Classe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClasseInputDTO {

    private Long voo_id;
    private String tipo;
    private Integer qtdAssentos;
    private BigDecimal valor;

    public ClasseInputDTO(Classe entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
