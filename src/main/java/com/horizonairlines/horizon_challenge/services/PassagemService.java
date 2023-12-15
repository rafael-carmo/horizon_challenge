package com.horizonairlines.horizon_challenge.services;

import com.horizonairlines.horizon_challenge.dtos.PassagemDTO;
import com.horizonairlines.horizon_challenge.dtos.PassagemInputDTO;
import com.horizonairlines.horizon_challenge.dtos.PassagemVoucherDTO;
import com.horizonairlines.horizon_challenge.entities.Passagem;
import com.horizonairlines.horizon_challenge.exceptions.CodeUniqueExistsException;
import com.horizonairlines.horizon_challenge.exceptions.NotFoundException;
import com.horizonairlines.horizon_challenge.exceptions.SeatsNotAvailableException;
import com.horizonairlines.horizon_challenge.repositories.ClasseRepository;
import com.horizonairlines.horizon_challenge.repositories.CompradorRepository;
import com.horizonairlines.horizon_challenge.repositories.PassageiroRepository;
import com.horizonairlines.horizon_challenge.repositories.PassagemRepository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;
    @Autowired
    private PassageiroRepository passageiroRepository;
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private CompradorRepository compradorRepository;

    public Boolean assentosDisponiveis(Long classeId) {
        var classe = classeRepository.findById(classeId)
                .orElseThrow(() -> new NotFoundException("Classe não encontrada!"));

        var qtdPassagens = passagemRepository.countByClasseAndCanceladaFalse(classe);

        return classe.getQtdAssentos() <= qtdPassagens;
    }

    public PassagemDTO save(PassagemInputDTO passagemInputDto) {

        if (passagemRepository.existsByNumero(passagemInputDto.getNumero()))
            throw new CodeUniqueExistsException("Já existe uma passagem com este número.");

        var passageiro = passageiroRepository.findById(passagemInputDto.getPassageiro_id())
                .orElseThrow(() -> new NotFoundException("Passageiro não encontrado!"));
        var classe = classeRepository.findById(passagemInputDto.getClasse_id())
                .orElseThrow(() -> new NotFoundException("Classe não encontrada!"));
        var comprador = compradorRepository.findById(passagemInputDto.getComprador_id())
                .orElseThrow(() -> new NotFoundException("Comprador não encontrado!"));

        // REGRA: Não podem ser vendidas mais passagens
        // do que a capacidade máxima da classe.
        if (this.assentosDisponiveis(passagemInputDto.getClasse_id()))
            throw new SeatsNotAvailableException();

        var passagem = new Passagem();
        passagem.setPassageiro(passageiro);
        passagem.setClasse(classe);
        passagem.setComprador(comprador);
        passagem.setCancelada(false);

        // REAGRA: se houver despache de bagagem, deve ser acrescida uma taxa de 10% do
        // valor do
        // assento ao valor da passagem.
        if (passagemInputDto.getDespachoBagagem()) {
            BigDecimal extra = classe.getValor().multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(100));
            BigDecimal valorTotal = classe.getValor().add(extra);
            passagem.setPreco(valorTotal);
        }

        BeanUtils.copyProperties(passagemInputDto, passagem);

        Passagem result = passagemRepository.save(passagem);

        return new PassagemDTO(result);
    }

    public List<PassagemDTO> findByCpf(String cpf) {
        var passagens = passagemRepository.findByCpf(cpf);
        return passagens.stream().map(x -> new PassagemDTO(x)).toList();
    }

    public PassagemDTO cancelarPassagem(Long id) {
        var passagem = passagemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Passagem não encontrada!"));
        ;
        passagem.setCancelada(true);
        var result = passagemRepository.save(passagem);
        return new PassagemDTO(result);
    }

    public List<PassagemDTO> findAll() {
        var passagens = passagemRepository.findAll();
        return passagens.stream().map(x -> new PassagemDTO(x)).toList();
    }

    public PassagemVoucherDTO printVoucher(Long passagem_id) {
        var voucherProjection = passagemRepository.findByPassagemId(passagem_id);
        return new PassagemVoucherDTO(voucherProjection);
    }

}
