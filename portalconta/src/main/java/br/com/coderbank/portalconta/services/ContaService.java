package br.com.coderbank.portalconta.services;


import br.com.coderbank.portalconta.dtos.requests.ContaFinanceiraRequestDTO;
import br.com.coderbank.portalconta.dtos.responses.ContaFinanceiraResponseDTO;
import br.com.coderbank.portalconta.entities.Conta;
import br.com.coderbank.portalconta.exceptions.ContaJaExisteException;
import br.com.coderbank.portalconta.repositories.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    private Conta construirContaEntity(ContaFinanceiraRequestDTO contaFinanceiraRequestDTO) {

        var contaEntity = new Conta();
        contaEntity.setNumeroAgencia(1);
        contaEntity.setSaldo(BigDecimal.ZERO);
        contaEntity.setNumeroConta(gerarNumeroConta());
        BeanUtils.copyProperties(contaFinanceiraRequestDTO, contaEntity);
        return contaEntity;

    }

    public ContaFinanceiraResponseDTO salvar(final ContaFinanceiraRequestDTO contaFinanceiraRequestDTO) {

        var contaEntity = construirContaEntity(contaFinanceiraRequestDTO);

        verificarContaDuplicada(contaFinanceiraRequestDTO);


        contaRepository.save(contaEntity);
        return new ContaFinanceiraResponseDTO(contaEntity.getIdConta(),
                contaEntity.getIdCliente(),
                contaEntity.getNumeroAgencia(),
                contaEntity.getNumeroConta(),
                contaEntity.getSaldo());
    }



    private Integer  gerarNumeroConta() {
        int min = 100000;
        int max = 999999;
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    private void verificarContaDuplicada(ContaFinanceiraRequestDTO contaFinanceiraRequestDTO ) {
        final var idCliente = contaFinanceiraRequestDTO.idCliente();
        if(contaRepository.existsByIdCliente(idCliente)){
        throw new ContaJaExisteException("Já existe uma conta para o cliente com ID: " + idCliente);
        }


    }



}


