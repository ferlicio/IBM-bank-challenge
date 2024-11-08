package com.IBM.IBM_bank.Services;

import com.IBM.IBM_bank.Models.Conta;
import com.IBM.IBM_bank.Repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta buscarContaPorId(Long id) {
        Optional<Conta> conta = contaRepository.findById(id);
        return conta.orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public Conta atualizarConta(Long id, Conta contaAtualizada) {
        Conta contaExistente = buscarContaPorId(id);
        contaExistente.setSaldo(contaAtualizada.getSaldo());
        return contaRepository.save(contaExistente);
    }

    public void deletarConta(Long id) {
        contaRepository.deleteById(id);
    }

    public List<Conta> listarTodasContas() {
        return contaRepository.findAll();
    }
}
