package com.horizonairlines.horizon_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}
