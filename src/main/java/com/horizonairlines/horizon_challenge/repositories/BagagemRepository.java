package com.horizonairlines.horizon_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Bagagem;

@Repository
public interface BagagemRepository extends JpaRepository<Bagagem, Long> {

}
