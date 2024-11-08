package br.com.coderbank.portalconta.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "CB_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConta;


    @Column(nullable = false, unique = true)
    private UUID idCliente;


    @Column(nullable = false, length = 1)
    private Integer numeroAgencia;


    @Column(unique = true, length = 6)
    private Integer numeroConta;

    @Column
    private BigDecimal saldo;

    public void setNumeroAgencia(Integer numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public UUID getIdConta() {
        return idConta;
    }

    public void setIdConta() {
        this.idConta = idConta;
    }
}
