package com.IBM.IBM_bank.Repositories;

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

    List<Movimentacao> findByContaIdAndTipo(Long contaId, TipoMovimentacao tipo);

    List<Movimentacao> findByContaIdAndDataBetween(Long contaId, LocalDate dataInicio, LocalDate dataFim);

    List<Movimentacao> findByContaIdAndStatusPagamento(Long contaId, StatusPagamento statusPagamento);

    List<Movimentacao> findByContaIdAndTipoAndDataBetween(Long contaId, TipoMovimentacao tipo, LocalDate dataInicio, LocalDate dataFim);

    List<Movimentacao> findByContaIdAndDataBetweenAndStatusPagamento(Long contaId, LocalDate dataInicio, LocalDate dataFim, StatusPagamento statusPagamento);

    List<Movimentacao> findByContaIdAndTipoAndDataBetweenAndStatusPagamento(Long contaId, TipoMovimentacao tipo, LocalDate dataInicio, LocalDate dataFim, StatusPagamento statusPagamento);

    List<Movimentacao> findByContaIdAndTipoAndStatusPagamento(Long contaId, TipoMovimentacao tipo, StatusPagamento statusPagamento);

    // Buscar uma movimentação por ID (exemplo básico)
    Optional<Movimentacao> findById(Long id);
}
