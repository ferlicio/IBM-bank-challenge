package com.IBM.IBM_Bank.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ContaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;

    @Column(nullable = false, length = 10)
    private Double limiteCredito;

    @Column(nullable = false, length = 50)
    private Double saldoUtilizado;

    @Column(nullable = false)
    private StatusConta status;

    @Column(nullable = false)
    private String dataFechamento; // Exemplo: "dd-MM" ou outro formato

    @Column(nullable = false)
    private String dataPagamento;  // Exemplo: "dd-MM"

    @OneToMany(mappedBy = "contaCredito", cascade = CascadeType.ALL)
    private List<Movimentacao> movimentacoesCredito;

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

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(Double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public List<Movimentacao> getMovimentacoesCredito() {
        return movimentacoesCredito;
    }

    public void setMovimentacoesCredito(List<Movimentacao> movimentacoesCredito) {
        this.movimentacoesCredito = movimentacoesCredito;
    }

    public StatusConta getStatus() {
        return status;
    }

    public void setStatus(StatusConta status) {
        this.status = status;
    }
}

