package com.IBM.IBM_Bank.Repositories;

import com.IBM.IBM_bank.Models.ContaCredito;
import com.IBM.IBM_bank.Models.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaCreditoRepository extends JpaRepository<ContaCredito, Long> {

    // Buscar uma conta de crédito por cliente
    Optional<ContaCredito> findByClienteId(Long clienteId);

    // Buscar todas as contas de crédito com limite superior a um valor específico
    List<ContaCredito> findByLimiteCreditoGreaterThan(Double limiteCredito);

    // Buscar contas de crédito pelo status (ativa, suspensa, etc)
    List<ContaCredito> findByStatus(String status);

    // Buscar contas de crédito com fatura pendente
    List<ContaCredito> findByStatusPagamento(StatusPagamento statusPagamento);

    // Buscar contas de crédito de um cliente e tipo de conta específico
    List<ContaCredito> findByClienteIdAndTipoConta(Long clienteId, String tipoConta);
}
