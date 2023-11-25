package com.horizonairlines.horizon_challenge.dtos;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.horizonairlines.horizon_challenge.entities.Aeroporto;
import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Voo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class VooUpdateDTO {

    private Long aeroporto_origem_id;
    private Long aeroporto_destino_id;
    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;
    // private Set<Classe> classes;
    private LocalDateTime dataPartida;
    private Integer number;

    public VooUpdateDTO(Voo entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
