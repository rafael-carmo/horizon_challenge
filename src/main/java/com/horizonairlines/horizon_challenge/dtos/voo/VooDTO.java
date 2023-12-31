package com.horizonairlines.horizon_challenge.dtos.voo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Aeroporto;
import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Voo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VooDTO {

    private Long id;
    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;
    private List<Classe> classes;
    private LocalDateTime dataPartida;
    private Integer number;
    private Boolean cancelado;

    public VooDTO(Voo entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
