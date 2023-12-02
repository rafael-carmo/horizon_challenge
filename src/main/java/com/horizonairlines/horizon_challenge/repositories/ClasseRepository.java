package com.horizonairlines.horizon_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    public Boolean existsByTipo(String tipo);
}
