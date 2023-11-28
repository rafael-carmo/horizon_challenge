package com.horizonairlines.horizon_challenge.projections;

import java.time.LocalDate;

public interface PassageiroProjection {
    Long getId();

    String getNome();

    String getCpf();

    LocalDate getDataNascimento();

}
