package com.horizonairlines.horizon_challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

    @Query("SELECT po FROM Passageiro po INNER JOIN po.passagens p INNER JOIN p.classe c INNER JOIN c.voo v WHERE v.id = :id")
    List<Passageiro> findByVoo(Long id);
}
