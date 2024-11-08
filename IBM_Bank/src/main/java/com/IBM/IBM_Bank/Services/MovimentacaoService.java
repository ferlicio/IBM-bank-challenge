package com.IBM.IBM_Bank.Services;

import com.IBM.IBM_bank.Models.Conta;
import com.IBM.IBM_bank.Models.ContaCredito;
import com.IBM.IBM_bank.Models.Movimentacao;
import com.IBM.IBM_bank.Models.TipoMovimentacao;
import com.IBM.IBM_bank.Repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Movimentacao buscarMovimentacaoPorId(Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        return movimentacao.orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
    }

    public List<Movimentacao> listarTodasMovimentacoes() {
        return movimentacaoRepository.findAll();
    }
}

