package com.IBM.IBM_Bank.Repositories;

import com.IBM.IBM_bank.Models.Movimentacao;
import com.IBM.IBM_bank.Models.StatusPagamento;
import com.IBM.IBM_bank.Models.TipoMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    // Buscar movimentações por conta (assumindo que a Conta tem um relacionamento @ManyToOne)
    List<Movimentacao> findByContaId(Long contaId);

    // Buscar movimentações de um tipo específico (débito ou crédito)
    List<Movimentacao> findByTipo(TipoMovimentacao tipo);

    // Buscar movimentações de um cliente específico
    List<Movimentacao> findByContaClienteId(Long clienteId);

    // Buscar movimentações com um status específico
    List<Movimentacao> findByStatusPagamento(StatusPagamento status);

    // Buscar movimentações por tipo de conta (de um cliente específico)
    List<Movimentacao> findByContaTipoConta(String tipoConta);

    // Buscar movimentações em um período de tempo (exemplo de consulta mais complexa)
    List<Movimentacao> findByDataBetween(LocalDate startDate, LocalDate endDate);

    // Buscar uma movimentação por ID (exemplo básico)
    Optional<Movimentacao> findById(Long id);
}
