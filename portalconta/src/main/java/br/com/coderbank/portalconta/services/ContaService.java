package br.com.coderbank.portalconta.services;


import br.com.coderbank.portalconta.dtos.requests.ContaRequestDTO;
import br.com.coderbank.portalconta.dtos.responses.ContaResponseDTO;
import br.com.coderbank.portalconta.entities.Conta;
import br.com.coderbank.portalconta.repositories.ContaRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public ContaResponseDTO salvar(final ContaRequestDTO contaRequestDTO) {

        var contaEntity = new Conta();

       contaEntity.setNumeroAgencia(1);

        contaEntity.setSaldo(BigDecimal.ZERO);


        contaEntity.setNumeroConta(geraNumeroConta());

            BeanUtils.copyProperties(contaRequestDTO, contaEntity);
            contaRepository.save(contaEntity);

            return new ContaResponseDTO(contaEntity.getIdConta(),
                    contaEntity.getIdCliente(),
                    contaEntity.getNumeroAgencia(),
                    contaEntity.getNumeroConta(),
                    contaEntity.getSaldo()


            );


    }

    private Integer geraNumeroConta(){
        var gerador = this.contaRepository.findAll().size();
        return  gerador+1;
    }



    }


