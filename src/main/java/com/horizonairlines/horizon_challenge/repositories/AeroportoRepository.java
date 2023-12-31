package com.horizonairlines.horizon_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {

    public Aeroporto findByCodigoIata(String codigoIata);
}
