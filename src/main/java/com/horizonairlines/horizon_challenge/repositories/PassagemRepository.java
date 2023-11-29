package com.horizonairlines.horizon_challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

    // @Query(value = "SELECT p FROM Passagem p WHERE p.comprador.cpf :cpf")
    @Query(value = "SELECT p FROM Passagem p WHERE p.comprador.cpf = :cpf")
    List<Passagem> findByCpf(String cpf);
}
