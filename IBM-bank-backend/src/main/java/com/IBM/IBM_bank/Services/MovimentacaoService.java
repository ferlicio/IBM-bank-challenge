package com.IBM.IBM_bank.Services;

import com.IBM.IBM_bank.Models.*;
import com.IBM.IBM_bank.Repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaCreditoService contaCreditoService;

    public Movimentacao registrarMovimentacao(Movimentacao movimentacao) {
        // Validar e aplicar lógica de negócio, como saldo suficiente ou limite de crédito
        if (movimentacao.getConta() != null) {
            Conta conta = contaService.buscarContaPorId(movimentacao.getConta().getId());
            if (movimentacao.getTipo() == TipoMovimentacao.DEBITO) {
                if (conta.getSaldo() < movimentacao.getValor()) {
                    throw new RuntimeException("Saldo insuficiente");
                }
                conta.setSaldo(conta.getSaldo() - movimentacao.getValor());
            } else {
                conta.setSaldo(conta.getSaldo() + movimentacao.getValor());
            }
            contaService.atualizarConta(conta.getId(), conta);
        } else if (movimentacao.getContaCredito() != null) {
            ContaCredito contaCredito = contaCreditoService.buscarContaCreditoPorId(movimentacao.getContaCredito().getId());
            // Adicionar lógica de negócio específica para conta de crédito, como verificar limite
        }

        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> listarMovimentacoesPorFiltros(Long contaId, TipoMovimentacao tipo, LocalDate dataInicio, LocalDate dataFim, StatusPagamento statusPagamento) {
        // Verifica quais filtros foram fornecidos e faz a busca correspondente
        if (tipo != null && dataInicio != null && dataFim != null && statusPagamento != null) {
            return movimentacaoRepository.findByContaIdAndTipoAndDataBetweenAndStatusPagamento(contaId, tipo, dataInicio, dataFim, statusPagamento);
        } else if (tipo != null && dataInicio != null && dataFim != null) {
            return movimentacaoRepository.findByContaIdAndTipoAndDataBetween(contaId, tipo, dataInicio, dataFim);
        } else if (dataInicio != null && dataFim != null && statusPagamento != null) {
            return movimentacaoRepository.findByContaIdAndDataBetweenAndStatusPagamento(contaId, dataInicio, dataFim, statusPagamento);
        } else if (tipo != null && statusPagamento != null) {
            return movimentacaoRepository.findByContaIdAndTipoAndStatusPagamento(contaId, tipo, statusPagamento);
        } else if (dataInicio != null && dataFim != null) {
            return movimentacaoRepository.findByContaIdAndDataBetween(contaId, dataInicio, dataFim);
        } else if (tipo != null) {
            return movimentacaoRepository.findByContaIdAndTipo(contaId, tipo);
        } else if (statusPagamento != null) {
            return movimentacaoRepository.findByContaIdAndStatusPagamento(contaId, statusPagamento);
        } else {
            // Caso nenhum filtro adicional seja fornecido, retorna todas as movimentações da conta
            return movimentacaoRepository.findByContaId(contaId);
        }
    }

    public Movimentacao buscarMovimentacaoPorId(Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        return movimentacao.orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
    }

    public List<Movimentacao> listarTodasMovimentacoes() {
        return movimentacaoRepository.findAll();
    }
}

