package com.IBM.IBM_bank.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConta tipoConta;  // Tipo da conta (e.g., "CORRENTE", "POUPANCA")

    @Column(nullable = false)
    private Double saldo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private StatusConta status;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false, unique = true)
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<Movimentacao> movimentacoes;

    @JsonIgnore
    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    private ContaCredito contaCredito;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public StatusConta getStatus() {
        return status;
    }

    public void setStatus(StatusConta status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public ContaCredito getContaCredito() {
        return contaCredito;
    }

    public void setContaCredito(ContaCredito contaCredito) {
        this.contaCredito = contaCredito;
    }
}

