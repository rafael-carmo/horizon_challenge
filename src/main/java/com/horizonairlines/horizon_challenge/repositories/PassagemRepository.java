package com.horizonairlines.horizon_challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horizonairlines.horizon_challenge.entities.Classe;
import com.horizonairlines.horizon_challenge.entities.Passagem;
import com.horizonairlines.horizon_challenge.projections.VoucherProjection;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

    @Query(value = "SELECT p FROM Passagem p INNER JOIN p.comprador c WHERE c.cpf = :cpf")
    List<Passagem> findByCpf(String cpf);

    // @Query(value = "SELECT p.numero AS numeroPassagem, v.numero AS numeroVoo,
    // v.aeroportoOrigem.nome AS nomeAeroportoOrigem, v.aeroportoDestino.nome AS
    // nomeAeroportoDestino, po.nome AS nomePassageiro, po.cpf AS cpfPassageiro,
    // p.despachoBagagem FROM Passagem p INNER JOIN p.passageiro po INNER JOIN
    // p.classe c INNER JOIN c.voo v WHERE p.id = :id ")
    @Query(nativeQuery = true, value = """
            SELECT p.numero AS numeroPassagem,
            v.numero AS numeroVoo,
            ori.nome AS nomeAeroportoOrigem,
            dest.nome AS nomeAeroportoDestino,
            po.nome AS nomePassageiro,
            po.cpf AS cpfPassageiro,
            p.despacho_bagagem AS despachoBagagem
            FROM passagem p
            INNER JOIN passageiro po ON p.passageiro_id = po.id
            INNER JOIN classe c ON p.classe_id = c.id
            INNER JOIN voo v ON c.voo_id = v.id
            INNER JOIN aeroporto ori ON v.aeroporto_origem_id = ori.id
            INNER JOIN aeroporto dest ON v.aeroporto_destino_id = dest.id
            WHERE p.id = :id
            """)
    VoucherProjection findByPassagemId(Long id);

    Boolean existsByNumero(Integer numero);

    Integer countByClasseAndCanceladaFalse(Classe classe);
}
