package com.horizonairlines.horizon_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Voo;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    Boolean existsByTipoAndVoo(String tipo, Voo voo);
}
