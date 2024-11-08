package br.com.coderbank.portalconta.dtos.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record ContaFinanceiraResponseDTO(

        UUID idConta,
        UUID idCliente,
        Integer numeroAgencia,
        Integer numeroConta,
        BigDecimal saldo

){

}


