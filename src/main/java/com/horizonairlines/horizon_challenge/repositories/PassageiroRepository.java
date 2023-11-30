package com.horizonairlines.horizon_challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Passageiro;
import com.horizonairlines.horizon_challenge.projections.PassageiroProjection;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

    // @Query(nativeQuery = true, value = """
    // SELECT po.id, po.nome, po.cpf, po.data_nascimento AS dataNascimento FROM
    // passagem p
    // INNER JOIN classe c ON p.classe_id = c.id
    // INNER JOIN passageiro po ON p.passageiro_id = po.id
    // INNER JOIN voo v ON c.voo_id = v.id
    // WHERE v.id = 1
    // """)
    // List<PassageiroProjection> findByVoo(Long id);

    @Query("SELECT po FROM Passageiro po INNER JOIN po.passagens p INNER JOIN p.classe c INNER JOIN c.voo v WHERE v.id = :id")
    List<Passageiro> findByVoo2(Long id);
}
