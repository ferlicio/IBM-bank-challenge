package com.IBM.IBM_Bank.Services;

import com.IBM.IBM_bank.Models.ContaCredito;
import com.IBM.IBM_bank.Repositories.ContaCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaCreditoService {

    @Autowired
    private ContaCreditoRepository contaCreditoRepository;

    public ContaCredito criarContaCredito(ContaCredito contaCredito) {
        return contaCreditoRepository.save(contaCredito);
    }

    public ContaCredito buscarContaCreditoPorId(Long id) {
        Optional<ContaCredito> contaCredito = contaCreditoRepository.findById(id);
        return contaCredito.orElseThrow(() -> new RuntimeException("Conta de Crédito não encontrada"));
    }

    public ContaCredito atualizarContaCredito(Long id, ContaCredito contaCreditoAtualizada) {
        ContaCredito contaCreditoExistente = buscarContaCreditoPorId(id);
        contaCreditoExistente.setLimite(contaCreditoAtualizada.getLimite());
        contaCreditoExistente.setDataFechamento(contaCreditoAtualizada.getDataFechamento());
        contaCreditoExistente.setDataPagamento(contaCreditoAtualizada.getDataPagamento());
        return contaCreditoRepository.save(contaCreditoExistente);
    }

    public void deletarContaCredito(Long id) {
        contaCreditoRepository.deleteById(id);
    }

    public List<ContaCredito> listarTodasContasCredito() {
        return contaCreditoRepository.findAll();
    }
}
