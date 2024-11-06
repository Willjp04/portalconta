package br.com.coderbank.portalconta.repositories;

import br.com.coderbank.portalconta.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {



}
