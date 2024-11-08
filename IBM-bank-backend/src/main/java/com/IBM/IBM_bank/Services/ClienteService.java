package com.IBM.IBM_bank.Services;

import com.IBM.IBM_bank.Models.Cliente;
import com.IBM.IBM_bank.Models.Conta;
import com.IBM.IBM_bank.Models.StatusConta;
import com.IBM.IBM_bank.Models.TipoConta;
import com.IBM.IBM_bank.Repositories.ClienteRepository;
import com.IBM.IBM_bank.Repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Transactional
    public Cliente criarClienteComConta(Cliente cliente) {
        // Salvar o cliente no banco de dados
        Cliente clienteSalvo = clienteRepository.save(cliente);

        // Criar uma nova conta com saldo zero e associar ao cliente
        Conta novaConta = new Conta();
        novaConta.setId(clienteSalvo.getConta().getId());
        novaConta.setTipoConta(TipoConta.CORRENTE);
        novaConta.setSaldo(0.0); // Saldo inicial zero
        novaConta.setStatus(StatusConta.ATIVA);
        novaConta.setCliente(clienteSalvo); // Associar a conta ao cliente salvo

        // Salvar a conta no banco de dados
        Conta conta = contaRepository.save(novaConta);

        clienteSalvo.setConta(conta);

        // Retornar o cliente salvo (pode incluir a conta se quiser)
        return clienteSalvo;
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarClientePorId(id);
        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setIdade(clienteAtualizado.getIdade());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        return clienteRepository.save(clienteExistente);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }
}
