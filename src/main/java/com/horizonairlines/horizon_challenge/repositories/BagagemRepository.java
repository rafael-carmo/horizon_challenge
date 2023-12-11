package com.horizonairlines.horizon_challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Bagagem;
import com.horizonairlines.horizon_challenge.projections.EtiquetaProjection;

@Repository
public interface BagagemRepository extends JpaRepository<Bagagem, Long> {

    // @Query(value = "SELECT p.numero AS numeroPassagem, b.numero AS numeroBagagem,
    // po.nome AS nomePassageiro FROM Bagagem b INNER JOIN b.passagem p WHERE p.id =
    // :id")
    // List<EtiquetaProjection> findEtiquetaByPassagem(Long id);

    // @Query(value = "SELECT p.numero AS numeroPassagem, b.numero AS numeroBagagem,
    // p.passageiro.nome AS nomePassageiro FROM Bagagem b INNER JOIN b.passagem p
    // WHERE b.numero = :numero")
    @Query(nativeQuery = true, value = """
            SELECT p.numero AS numeroPassagem,
            b.numero AS numeroBagagem,
            po.nome AS nomePassageiro
            FROM bagagem b
            INNER JOIN passagem p ON b.passagem_id = p.id
            INNER JOIN passageiro po ON p.passageiro_id = po.id
            WHERE b.numero = :numero
            """)
    EtiquetaProjection findEtiquetaByNumero(Integer numero);

}
