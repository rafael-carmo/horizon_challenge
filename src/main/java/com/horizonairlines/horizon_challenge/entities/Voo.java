package com.horizonairlines.horizon_challenge.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Voo implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aeroporto_origem_id")
    private Aeroporto aeroportoOrigem;

    @ManyToOne
    @JoinColumn(name = "aeroporto_destino_id")
    private Aeroporto aeroportoDestino;

    @OneToMany(mappedBy = "voo", fetch = FetchType.EAGER)
    private List<Classe> classes;

    @JoinColumn(name = "data_partida")
    private LocalDateTime dataPartida;

    private Integer numero;
    private Boolean cancelado;

}
