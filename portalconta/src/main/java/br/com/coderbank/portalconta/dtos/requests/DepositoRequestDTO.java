package br.com.coderbank.portalconta.dtos.requests;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.UUID;

public record DepositoRequestDTO(

        UUID idConta,

        BigDecimal valor
) {
}
