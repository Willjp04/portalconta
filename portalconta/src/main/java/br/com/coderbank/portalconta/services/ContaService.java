package br.com.coderbank.portalconta.services;


import br.com.coderbank.portalconta.dtos.requests.ContaFinanceiraRequestDTO;
import br.com.coderbank.portalconta.dtos.responses.ContaFinanceiraResponseDTO;
import br.com.coderbank.portalconta.entities.Conta;
import br.com.coderbank.portalconta.repositories.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public ContaFinanceiraResponseDTO salvar(final ContaFinanceiraRequestDTO contaFinanceiraRequestDTO) {

        var contaEntity = new Conta();

       contaEntity.setNumeroAgencia(1);

        contaEntity.setSaldo(BigDecimal.ZERO);


        contaEntity.setNumeroConta(geraNumeroConta());

            BeanUtils.copyProperties(contaFinanceiraRequestDTO, contaEntity);
            contaRepository.save(contaEntity);

            return new ContaFinanceiraResponseDTO(contaEntity.getIdConta(),
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


