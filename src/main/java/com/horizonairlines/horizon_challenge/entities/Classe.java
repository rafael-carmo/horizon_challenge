package com.horizonairlines.horizon_challenge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "classe")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Classe implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Voo voo;

    @JsonIgnore
    @OneToMany(mappedBy = "classe", fetch = FetchType.LAZY)
    private List<Passagem> passagens;

    private String tipo;
    private Integer qtdAssentos;
    private BigDecimal valor;

}
