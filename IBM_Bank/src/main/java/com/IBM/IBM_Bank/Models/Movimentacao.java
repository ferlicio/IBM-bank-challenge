package com.IBM.IBM_Bank.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    @Column(nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "conta_credito_id")
    private ContaCredito contaCredito;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento statusPagamento; // "PENDENTE" ou "PAGO"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo; // "DEBITO" ou "CREDITO"

    @Column(nullable = false, length = 10)
    private Double valor;
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataMovimentacao;

    @Column(nullable = false)
    private LocalDate dataCompetencia; // Mês e ano da competência (e.g., "MM-yyyy")

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ContaCredito getContaCredito() {
        return contaCredito;
    }

    public void setContaCredito(ContaCredito contaCredito) {
        this.contaCredito = contaCredito;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public LocalDate getDataCompetencia() {
        return dataCompetencia;
    }

    public void setDataCompetencia(LocalDate dataCompetencia) {
        this.dataCompetencia = dataCompetencia;
    }
}

