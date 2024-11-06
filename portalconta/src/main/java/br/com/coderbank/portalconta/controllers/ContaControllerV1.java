package br.com.coderbank.portalconta.controllers;

import br.com.coderbank.portalconta.dtos.requests.ContaRequestDTO;
import br.com.coderbank.portalconta.dtos.responses.ContaResponseDTO;
import br.com.coderbank.portalconta.entities.Conta;
import br.com.coderbank.portalconta.repositories.ContaRepository;
import br.com.coderbank.portalconta.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaControllerV1 {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaService contaService;

        @PostMapping
        public ResponseEntity<ContaResponseDTO> salvar(@RequestBody ContaRequestDTO contaRequestDTO) {
            return ResponseEntity.status(HttpStatus.CREATED).body(contaService.salvar(contaRequestDTO));
        }

}
