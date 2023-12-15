package com.horizonairlines.horizon_challenge.dtos.passageiro;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Passageiro;
import com.horizonairlines.horizon_challenge.projections.PassageiroProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PassageiroDTO {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public PassageiroDTO(Passageiro entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public PassageiroDTO(PassageiroProjection projection) {
        id = projection.getId();
        nome = projection.getNome();
        cpf = projection.getCpf();
        dataNascimento = projection.getDataNascimento();
    }

}
