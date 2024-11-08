package com.IBM.IBM_bank.Controllers;

import com.IBM.IBM_bank.Models.ContaCredito;
import com.IBM.IBM_bank.Services.ContaCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas-credito")
public class ContaCreditoController {

    @Autowired
    private ContaCreditoService contaCreditoService;

    @PostMapping
    public ResponseEntity<ContaCredito> criarContaCredito(@RequestBody ContaCredito contaCredito) {
        return ResponseEntity.ok(contaCreditoService.criarContaCredito(contaCredito));
    }

    @GetMapping
    public ResponseEntity<List<ContaCredito>> listarContasCredito() {
        return ResponseEntity.ok(contaCreditoService.listarTodasContasCredito());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaCredito> buscarContaCredito(@PathVariable Long id) {
        return ResponseEntity.ok(contaCreditoService.buscarContaCreditoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaCredito> atualizarContaCredito(@PathVariable Long id, @RequestBody ContaCredito contaCredito) {
        return ResponseEntity.ok(contaCreditoService.atualizarContaCredito(id, contaCredito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContaCredito(@PathVariable Long id) {
        contaCreditoService.deletarContaCredito(id);
        return ResponseEntity.noContent().build();
    }

}
