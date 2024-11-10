package br.com.coderbank.portalconta.dtos.requests;

import java.math.BigDecimal;
import java.util.UUID;

public record SaqueRequestDTO(
        UUID idConta,

        BigDecimal valor
) {
}
