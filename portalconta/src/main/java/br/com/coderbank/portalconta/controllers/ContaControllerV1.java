package br.com.coderbank.portalconta.controllers;

import br.com.coderbank.portalconta.dtos.requests.ContaFinanceiraRequestDTO;
import br.com.coderbank.portalconta.dtos.responses.ContaFinanceiraResponseDTO;
import br.com.coderbank.portalconta.dtos.responses.SaldoResponseDTO;
import br.com.coderbank.portalconta.repositories.ContaRepository;
import br.com.coderbank.portalconta.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaControllerV1 {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaFinanceiraResponseDTO> salvar(@RequestBody ContaFinanceiraRequestDTO contaFinanceiraRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.salvar(contaFinanceiraRequestDTO));
    }


    @GetMapping("/{idCliente}")
    public ResponseEntity<SaldoResponseDTO> buscaSaldoPorIdCliente(@PathVariable UUID idCliente) {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.obterSaldoPorIdCliente(idCliente));
    }
}